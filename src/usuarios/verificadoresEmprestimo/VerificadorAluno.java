package src.usuarios.verificadoresEmprestimo;

import src.livro.Livro;
import src.usuarios.IVerificadorEmprestimo;
import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.verificadores.*;
import src.utils.Console;

public class VerificadorAluno implements IVerificadorEmprestimo {

    public boolean verificadorEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeExemplaresLivres() == 0) {
            Console.imprimirMensagem("Não há exemplares livres no momento");
            return false;
        }

        if (!VerificadorAtraso.usuarioEValido(usuario)){
            Console.imprimirMensagem("O usuário '%s' está em débito com a biblioteca",
                    usuario.getNome()
            );
            return false;
        }

        if (!VerificadorLimiteEmprestimos.usuarioEValido(usuario)) {
            Console.imprimirMensagem("O usuário '%s' atingiu o seu limite de empréstimos ativos!",
                    usuario.getNome()
            );
            return false;
        }

        if (!VerificadorReservas.usuarioEValido(usuario, livro) && livro.getQuantidadeReservas() >= livro.getQuantidadeExemplaresLivres()){
            Console.imprimirMensagem("Todos os exemplares livres do livro '%s' já foram reservados, " +
                            "mas o usuário '%s' não possui uma reserva para este livro",
                    livro.getTitulo(),
                    usuario.getNome()
            );
            return false;
        }

        if (!VerificadorEmprestimoAtivoLivro.usuarioEValido(usuario, livro)){
            Console.imprimirMensagem("O usuário '%s' já possui um exemplar do livro '%s' com empréstimo ativo",
                    usuario.getNome(),
                    livro.getTitulo()
            );
            return false;
        }

        return true;
    }
}
