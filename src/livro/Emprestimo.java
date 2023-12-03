package src.livro;

import java.util.Date;
import src.usuarios.Usuario;

public class Emprestimo {
    private Date dataEmprestimo;
    private Exemplar exemplar;
    private Usuario usuario;
    
    Emprestimo(Exemplar exemplar, Usuario usuario){
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataEmprestimo = new Date();
    }
    
    public Exemplar getExemplar() {
        return exemplar;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public Date getDataEmprestimo(){
        return this.dataEmprestimo;
    }
}
