package src.livro;

import src.usuarios.Usuario;

public class Exemplar {
    private Livro livro;
    private Emprestimo emprestimo = null;
    
    Exemplar(Livro livro){
        this.livro = livro;
    }
    
    public Livro getLivro() {
        return livro;
    }
    
    public boolean disponivel() {
        return this.emprestimo == null;
    }

    public void emprestar(Usuario usuario){
        if (!usuario.getVerificadorEmprestimo().verificadorEmprestimo(usuario, this.livro)){
            return;
        }

        this.livro.removerReserva(usuario);

        Emprestimo emprestimo = new Emprestimo(this, usuario);
        this.emprestimo = emprestimo;
        usuario.adicionarEmprestimo(emprestimo);
    }

    public void cancelarEmprestimo(){
        this.emprestimo.getUsuario().removerEmprestimo(emprestimo);
        this.emprestimo = null;
    }
}
