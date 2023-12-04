package src.usuarios.verificadoresEmprestimo;

import src.livro.Livro;
import src.usuarios.IVerificadorEmprestimo;
import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.verificadores.*;

public class VerificadorProfessor implements IVerificadorEmprestimo {
    
    public boolean verificadorEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeExemplaresLivres() == 0){
            return false;
        }

        if (!VerificadorAtraso.usuarioEValido(usuario)){
            return false;
        }
        
        return true;
    }
}
