package src.usuarios.verificadoresEmprestimo.verificadores;

import java.time.LocalDate;
import src.livro.Emprestimo;
import src.usuarios.IEmprestimosTempoLimitado;
import src.usuarios.Usuario;

// Verifica se o usuário é "devedor" de um livro em atraso
public class VerificadorAtraso {
    public static boolean usuarioEValido(Usuario usuario){
        IEmprestimosTempoLimitado usuario_ = (IEmprestimosTempoLimitado) usuario;

        LocalDate hoje = LocalDate.now();
        for (Emprestimo emprestimo: usuario.getEmprestimosAtivos()){
            if (hoje.compareTo(emprestimo.getDataEmprestimo()) > usuario_.getLimiteTempoEmprestimo()){
                return false;
            }
        }

        return true;
    }
}