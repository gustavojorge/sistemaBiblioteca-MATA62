package src.utils;

import java.time.LocalDate;
import src.livro.Emprestimo;
import src.livro.Exemplar;
import src.livro.Livro;
import src.livro.Reserva;
import src.observador.Observador;
import src.usuarios.Usuario;
import src.utils.Console;

public class FachadaSingleton {
    private BancoDeDados bancoDeDados = BancoDeDados.obterInstanciaBancoDeDados();
    private static FachadaSingleton instancia;
    private FachadaSingleton() {};

    public static FachadaSingleton obterInstancia() {
        if (instancia == null) {
            instancia = new FachadaSingleton();
        }
        return instancia;
    }

    public void FazerEmprestimo(String codigoUsuario, String codigoLivro){
        Usuario usuario = bancoDeDados.obterUsuarioPorId(Integer.parseInt(codigoUsuario));
        Livro livro = bancoDeDados.obterLivroPorId(Integer.parseInt(codigoLivro));
        
        if (usuario.getVerificadorEmprestimo().verificadorEmprestimo(usuario, livro)){
            try{
                livro.obterExemplarLivre().emprestar(usuario);
                Console.imprimirMensagem("Livro emprestado com sucesso!\n");
            } catch (Exception e){
                // Esse bloco nunca será executado, pois verificadorEmprestimo retorna false se não há exemplares livres
            }
        }
    }

    public void FazerReserva(String codigoUsuario, String codigoLivro){
        Usuario usuario = bancoDeDados.obterUsuarioPorId(Integer.parseInt(codigoUsuario));
        Livro livro = bancoDeDados.obterLivroPorId(Integer.parseInt(codigoLivro));

        try{
            livro.adicionarReserva(usuario);
            Console.imprimirMensagem("Reserva feita com sucesso!\n");
        } catch (Exception e){
            Console.imprimirMensagem("Não foi possível fazer a reserva pelo seguinte motivo: "+e.getMessage());
        }
    }

    public void ConsultarLivro(String codigoLivro){
        Livro livro = bancoDeDados.obterLivroPorId(Integer.parseInt(codigoLivro));
        
        // Imprime o título do livro
        Console.imprimirMensagem("Título: %s\n", livro.getTitulo());

        // Imprime as reservas do livro
        if (livro.getQuantidadeReservas() == 0){
            Console.imprimirMensagem("Esse livro não possui reservas");
        } else {
            Console.imprimirMensagem("Esse livro possui %d reservas, feitas pelos seguintes usuários:\n", livro.getQuantidadeReservas());
            for (Reserva reserva: livro.getReservas()){
                Console.imprimirMensagem(reserva.getUsuario().getNome());
            }
        }

        // Imprime os exemplares do livro
        if (livro.getQuantidadeTotalExemplares() == 0){
            Console.imprimirMensagem("Esse livro não possui exemplares");
        } else {
            Console.imprimirMensagem("Esse livro possui os seguintes exemplares:");
            for (Exemplar exemplar: livro.getExemplares()){
                Console.imprimirMensagem("Código: %d; Status: %s",
                    exemplar.getId(),
                    (exemplar.disponivel())?"Disponível":"Emprestado"
                );

                if (!exemplar.disponivel()){
                    LocalDate dataEmpr = exemplar.getEmprestimo().getDataEmprestimo();
                    LocalDate dataDev = exemplar.getEmprestimo().getDataDevolucao();

                    Console.imprimirMensagem(" (Emprestado para %s no dia %s. Devolução em %s)",
                        exemplar.getEmprestimo().getUsuario().getNome(),
                        String.format("%02d/%02d/%04d", dataEmpr.getDayOfMonth(), dataEmpr.getMonthValue(), dataEmpr.getYear()),
                        String.format("%02d/%02d/%04d", dataDev.getDayOfMonth(), dataDev.getMonthValue(), dataDev.getYear())
                    );
                }

                Console.imprimirMensagem("");
            }
        }
    }

    public void ConsultarObservador(String codigoObservador){
        Observador observador = (Observador) bancoDeDados.obterUsuarioPorId(Integer.parseInt(codigoObservador));
        Console.imprimirMensagem("Há %d notificações de reservas simultâneas para esse usuário\n", observador.getQuantidadeNotificacoes());
    }

    public void ConsultarUsuario(String codigoUsuario){
        Usuario usuario = bancoDeDados.obterUsuarioPorId(Integer.parseInt(codigoUsuario));

        Console.imprimirMensagem("Emprestimos desse usuário:");
        for (int i=usuario.getQuantidadeEmprestimosHistorico()-1; i >= 0; i--){
            Emprestimo e = usuario.getEmprestimosHistorico().get(i);
            LocalDate dataEmpr = e.getDataEmprestimo();
            LocalDate dataDev = e.getDataDevolucao();
            Console.imprimirMensagem("Título: %s; Emprestado em: %s; Devolução: %s; Status: %s\n",
                e.getExemplar().getLivro().getTitulo(),
                String.format("%02d/%02d/%04d", dataEmpr.getDayOfMonth(), dataEmpr.getMonthValue(), dataEmpr.getYear()),
                String.format("%02d/%02d/%04d", dataDev.getDayOfMonth(), dataDev.getMonthValue(), dataDev.getYear()),
                (e.isDevolvido())?"Devolvido":"Em curso"
            );
        }

        Console.imprimirMensagem("\nReservas ativas desse usuario:");
        for (int i=usuario.getQuantidadeReservas()-1; i >= 0; i--){
            Reserva r = usuario.getReservas().get(i);
            LocalDate dataRes = r.getDataReserva();
            Console.imprimirMensagem("Título: %s; Reserva solicitada em: %s",
                r.getLivro().getTitulo(),
                String.format("%02d/%02d/%04d", dataRes.getDayOfMonth(), dataRes.getMonthValue(), dataRes.getYear())
            );
        }
    }

    public void DevolverLivro(String codigoUsuario, String codigoLivro){
        Usuario usuario = bancoDeDados.obterUsuarioPorId(Integer.parseInt(codigoUsuario));
        Livro livro = bancoDeDados.obterLivroPorId(Integer.parseInt(codigoLivro));

        try{
            usuario.obterEmprestimo(livro).getExemplar().devolver();
            Console.imprimirMensagem("Livro devolvido com sucesso!\n");
        } catch (Exception e){
            Console.imprimirMensagem(e.getMessage());
        }
    }

    public void tornarObservador(String codigoUsuario, String codigoLivro){
        Observador observador = (Observador) bancoDeDados.obterUsuarioPorId(Integer.parseInt(codigoUsuario));
        Livro livro = bancoDeDados.obterLivroPorId(Integer.parseInt(codigoLivro));
        
        livro.RegistrarObservador(observador);
    }

    public void sair(){
        System.exit(0);
    }
}
