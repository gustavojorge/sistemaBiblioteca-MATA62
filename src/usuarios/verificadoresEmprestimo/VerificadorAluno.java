package src.usuarios.verificadoresEmprestimo;

import src.livro.Livro;
import src.usuarios.IVerificadorEmprestimo;
import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.verificadores.*;
import src.utils.Console;

public class VerificadorAluno implements IVerificadorEmprestimo {

    public boolean verificadorEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeExemplaresLivres() == 0) {
            Console.imprimirMensagem("O usuário '%s' não pode pegar o livro '%s' porque não há exemplares livres no momento",
                usuario.getNome(),
                livro.getTitulo()
            );
            return false;
        }

        if (!VerificadorAtraso.usuarioEValido(usuario)){
            Console.imprimirMensagem("O usuário '%s' não pode pegar o livro '%s' porque está em débito com a biblioteca",
                    usuario.getNome(),
                    livro.getTitulo()
            );
            return false;
        }

        if (!VerificadorLimiteEmprestimos.usuarioEValido(usuario)) {
            Console.imprimirMensagem("O usuário '%s' não pode pegar o livro '%s' porque atingiu o seu limite de empréstimos ativos!",
                    usuario.getNome(),
                    livro.getTitulo()
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
            Console.imprimirMensagem("O usuário '%s' já possui um empréstimo ativo do livro '%s'",
                    usuario.getNome(),
                    livro.getTitulo()
            );
            return false;
        }

        return true;
    }
}
