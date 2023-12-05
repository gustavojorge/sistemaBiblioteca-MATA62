package src.livro;

import java.time.LocalDate;
import src.usuarios.Usuario;

public class Reserva{
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataReserva;

    Reserva(Livro livro, Usuario usuario){
        this.livro = livro;
        this.usuario = usuario;
        this.dataReserva = LocalDate.now();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro(){
        return livro;
    }

    public LocalDate getDataReserva(){
        return dataReserva;
    }

    public boolean equals(Reserva reserva){
        return this.usuario.getId() == reserva.usuario.getId() && this.livro.getId() == reserva.livro.getId();
    }
}
