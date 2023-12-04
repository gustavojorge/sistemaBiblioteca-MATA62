package src.usuarios.verificadoresEmprestimo;

import src.livro.Livro;
import src.usuarios.IVerificadorEmprestimo;
import src.usuarios.Usuario;

public class VerificadorAluno implements IVerificadorEmprestimo {
    
    public boolean verificadorEmprestimo(Usuario usuario, Livro livro) {
        return true;
    }
}
