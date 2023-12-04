package src.usuarios.verificadoresEmprestimo.verificadores;

import java.time.LocalDate;
import src.livro.Emprestimo;
import src.usuarios.Usuario;

public class VerificadorAtraso {
    public static boolean usuarioEValido(Usuario usuario){
        LocalDate hoje = LocalDate.now();
        for (Emprestimo emprestimo: usuario.getEmprestimosAtivos()){
            if (hoje.compareTo(emprestimo.getDataEmprestimo()) > usuario.getLimiteTempoEmprestimo()){
                return false;
            }
        }

        return true;
    }
}