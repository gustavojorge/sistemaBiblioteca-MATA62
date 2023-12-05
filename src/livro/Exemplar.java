package src.livro;

import java.time.LocalDate;

import src.usuarios.Usuario;

public class Exemplar {
    private int id;
    private Livro livro;
    private Emprestimo emprestimo = null;
    
    Exemplar(Livro livro, int id){
        this.livro = livro;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }
    
    public boolean disponivel() {
        return this.emprestimo == null;
    }

    public void emprestar(Usuario usuario){
        this.livro.removerReserva(usuario);

        Emprestimo emprestimo = new Emprestimo(this, usuario);
        this.emprestimo = emprestimo;
        usuario.adicionarEmprestimo(emprestimo);
    }

    public void devolver(){
        this.emprestimo.getUsuario().removerEmprestimo(emprestimo);
        this.emprestimo.setDataDevolucao(LocalDate.now());
        this.emprestimo.setDevolvido(true);
        this.emprestimo = null;
    }
}
