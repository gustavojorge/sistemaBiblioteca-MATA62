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
        return this.emprestimo != null;
    }

    public void emprestar(Usuario usuario) throws Exception{
        if (!usuario.getVerificadorEmprestimo().verificadorEmprestimo(usuario, this.livro)){
            throw new Exception("O usuário não pode pegar livro emprestado!");
        }

        try {
            this.livro.removerReserva(usuario);
        } catch (Exception e) {
            // Nada faz...
        }

        Emprestimo emprestimo = new Emprestimo(this, usuario);
        this.emprestimo = emprestimo;
        usuario.adicionarEmprestimo(emprestimo);
    }

    public void cancelarEmprestimo(){
        this.emprestimo.getUsuario().removerEmprestimo(emprestimo);
        this.emprestimo = null;
    }
}
