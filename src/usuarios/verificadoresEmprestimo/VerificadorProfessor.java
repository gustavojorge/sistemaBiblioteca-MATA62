package src.usuarios.verificadoresEmprestimo;

import src.livro.Livro;
import src.usuarios.IVerificadorEmprestimo;
import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.verificadores.*;
import src.utils.Console;

public class VerificadorProfessor implements IVerificadorEmprestimo {

    public boolean verificadorEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeExemplaresLivres() == 0){
            Console.imprimirMensagem("Não há exemplares livres no momento");
            return false;
        }

        if (!VerificadorAtraso.usuarioEValido(usuario)){
            Console.imprimirMensagem("O usuário '%s' está em débito com a biblioteca",
                    usuario.getNome()
            );
            return false;
        }

        return true;
    }
}
