package src.usuarios;

import java.util.List;
import src.livro.Emprestimo;
import src.livro.Reserva;

public abstract class Usuario {
    protected int id;
    protected String nome;
    protected IVerificadorEmprestimo verificadorEmprestimo;
    protected List<Emprestimo> emprestimosAtivos;
    protected List<Emprestimo> emprestimosPassados;
    protected List<Reserva> reservas;
    protected int limiteQuantidadeEmprestimo;
    protected int limiteTempoEmprestimo;

    public Usuario(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        this.id = id;
        this.nome = nome;
        this.verificadorEmprestimo = verificadorEmprestimo;
    }

    public int getId() {
        return this.id;
    }

    /*public void setId(int identificacao) {
        this.id = identificacao;
    }*/

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLimiteTempoEmprestimo() {
        return this.limiteTempoEmprestimo;
    }

    public int getLimiteQuantidadeEmprestimos(){
        return this.limiteQuantidadeEmprestimo;
    }

    public List<Emprestimo> getEmprestimosAtivos(){
        return this.emprestimosAtivos;
    }

    public List<Emprestimo> getEmprestimosPassados(){
        return this.emprestimosPassados;
    }

    public List<Reserva> getReservas(){
        return this.reservas;
    }

    public int getQuantidadeEmprestimosAtivos(){
        return this.emprestimosAtivos.size();
    }

    public void adicionarEmprestimo(Emprestimo emprestimo){
        this.emprestimosAtivos.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo){
        this.emprestimosAtivos.remove(emprestimo);
        this.emprestimosPassados.add(emprestimo);
    }

    public void adicionarReserva(Reserva reserva) throws Exception{
        if (this.reservas.size() == 3)
            throw new Exception("Usuário já atingiu a quantidade máxima de reservas!");

        this.reservas.add(reserva);
    }

    public void removerReserva(Reserva reserva){
        this.reservas.remove(reserva);
    }

    public abstract void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo);

    public IVerificadorEmprestimo getVerificadorEmprestimo(){
        return this.verificadorEmprestimo;
    }
}
