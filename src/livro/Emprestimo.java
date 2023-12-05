package src.livro;

import java.time.LocalDate;
import src.usuarios.Usuario;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Exemplar exemplar;
    private Usuario usuario;
    private boolean devolvido;
    
    
    Emprestimo(Exemplar exemplar, Usuario usuario){
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = this.dataEmprestimo.plusDays(usuario.getLimiteTempoEmprestimo());
        this.devolvido = false;
    }
    
    public Exemplar getExemplar() {
        return exemplar;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public LocalDate getDataEmprestimo(){
        return dataEmprestimo;
    }
    
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    
    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
