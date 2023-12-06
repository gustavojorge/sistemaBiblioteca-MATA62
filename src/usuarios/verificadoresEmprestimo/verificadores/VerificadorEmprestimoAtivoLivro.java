package src.usuarios.verificadoresEmprestimo.verificadores;

import src.livro.Emprestimo;
import src.livro.Livro;
import src.usuarios.Usuario;

// Verifica se o usuário não possui um exemplar do livro
public class VerificadorEmprestimoAtivoLivro {
    public static boolean usuarioEValido(Usuario usuario, Livro livro){
        for (Emprestimo emprestimo: usuario.getEmprestimosAtivos()){
            if (emprestimo.getExemplar().getLivro().getId() == livro.getId())
                return false;

        }
        
        return true;
    }
}
