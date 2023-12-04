package src.livro;

import java.time.LocalDate;
import src.usuarios.Usuario;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private Exemplar exemplar;
    private Usuario usuario;
    
    Emprestimo(Exemplar exemplar, Usuario usuario){
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
    }
    
    public Exemplar getExemplar() {
        return exemplar;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo(){
        return this.dataEmprestimo;
    }
}
