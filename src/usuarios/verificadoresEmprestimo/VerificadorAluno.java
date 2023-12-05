package src.usuarios.verificadoresEmprestimo;

import src.livro.Livro;
import src.usuarios.IVerificadorEmprestimo;
import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.verificadores.*;

public class VerificadorAluno implements IVerificadorEmprestimo {
    
    public boolean verificadorEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeExemplaresLivres() == 0) {
            return false;
        }

        if (!VerificadorAtraso.usuarioEValido(usuario)){
            return false;
        }

        if (!VerificadorLimiteEmprestimos.usuarioEValido(usuario)) {
            return false;
        }

        if (!VerificadorReservas.usuarioEValido(usuario, livro) && livro.getQuantidadeReservas() >= livro.getQuantidadeExemplaresLivres()){
            return false;
        }

        if (!VerificadorEmprestimoAtivoLivro.usuarioEValido(usuario, livro)){
            return false;
        }

        return true;
    }
}
