package src.usuarios.verificadoresEmprestimo.verificadores;

import src.livro.Emprestimo;
import src.livro.Livro;
import src.usuarios.Usuario;

public class VerificadorEmprestimoAtivoLivro {
    public boolean usuarioEValido(Usuario usuario, Livro livro){
        for (Emprestimo emprestimo: usuario.getEmprestimosAtivos()){
            if (emprestimo.getExemplar().getLivro().getId() == livro.getId())
                return false;

        }
        
        return true;
    }
}
