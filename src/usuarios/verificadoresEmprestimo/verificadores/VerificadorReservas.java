package src.usuarios.verificadoresEmprestimo.verificadores;

import src.livro.Livro;
import src.livro.Reserva;
import src.usuarios.Usuario;

public class VerificadorReservas {
    public static boolean usuarioEValido(Usuario usuario, Livro livro){
        boolean usuarioReservado = false;

        for (Reserva reserva: livro.getReservas()){
            if (reserva.getUsuario().getId() == usuario.getId()){
                usuarioReservado = true;
                break;
            }
        }

        if (livro.getQuantidadeReservas() >= livro.getQuantidadeExemplaresLivres() && !usuarioReservado)
            return false;
        
        return true;
    }
}
