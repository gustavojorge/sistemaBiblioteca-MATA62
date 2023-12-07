package src.usuarios.verificadoresEmprestimo;

import src.livro.Livro;
import src.usuarios.IVerificadorEmprestimo;
import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.verificadores.*;
import src.utils.Console;

public class VerificadorProfessor implements IVerificadorEmprestimo {

    public boolean verificadorEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeExemplaresLivres() == 0){
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

        return true;
    }
}
