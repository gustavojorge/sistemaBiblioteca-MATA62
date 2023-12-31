package src.usuarios.verificadoresEmprestimo.verificadores;

import java.time.LocalDate;
import src.livro.Emprestimo;
import src.usuarios.Usuario;

// Verifica se o usuário não é "devedor" de um livro em atraso
public class VerificadorAtraso {
    public static boolean usuarioEValido(Usuario usuario){
        LocalDate hoje = LocalDate.now();
        for (Emprestimo emprestimo: usuario.getEmprestimosAtivos()){
            if (emprestimo.getDataDevolucao().compareTo(hoje) < 0){
                return false;
            }
        }

        return true;
    }
}