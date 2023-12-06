package src.usuarios.verificadoresEmprestimo.verificadores;

import src.livro.Livro;
import src.livro.Reserva;
import src.usuarios.Usuario;

// Verifica se o usuário possui reserva do livro
public class VerificadorReservas {
    public static boolean usuarioEValido(Usuario usuario, Livro livro){
        for (Reserva reserva: livro.getReservas()){
            if (reserva.getUsuario().getId() == usuario.getId()){
                return true;
            }
        }
        
        return false;
    }
}
