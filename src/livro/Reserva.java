package src.livro;

import src.usuarios.Usuario;

public class Reserva{
    private Usuario usuario;
    private Livro livro;

    Reserva(Livro livro, Usuario usuario){
        this.livro = livro;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean equals(Reserva reserva){
        return this.usuario.getId() == reserva.usuario.getId() && this.livro.getId() == reserva.livro.getId();
    }
}
