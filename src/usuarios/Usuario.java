package src.usuarios;

import java.util.ArrayList;
import java.util.List;
import src.livro.Emprestimo;
import src.livro.Livro;
import src.livro.Reserva;

public abstract class Usuario {
    protected int id;
    protected String nome;
    protected IVerificadorEmprestimo verificadorEmprestimo;
    protected List<Emprestimo> emprestimosAtivos = new ArrayList<Emprestimo>();
    protected List<Emprestimo> emprestimosHistorico = new ArrayList<Emprestimo>();
    protected List<Reserva> reservas = new ArrayList<Reserva>();
    protected int limiteTempoEmprestimo;

    public Usuario(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        this.id = id;
        this.nome = nome;
        this.verificadorEmprestimo = verificadorEmprestimo;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Emprestimo> getEmprestimosAtivos(){
        return this.emprestimosAtivos;
    }

    public List<Emprestimo> getEmprestimosHistorico(){
        return this.emprestimosHistorico;
    }

    public List<Reserva> getReservas(){
        return this.reservas;
    }

    public Emprestimo obterEmprestimoAtivo(Livro livro) throws Exception{
        for (Emprestimo emprestimo: emprestimosAtivos){
            if (emprestimo.getExemplar().getLivro() == livro){
                return emprestimo;
            }
        }

        throw new Exception(String.format(
            "O usuário '%s' não possui empréstimo ativo do livro '%s'",
            this.nome,
            livro.getTitulo()
        ));
    }

    public int getQuantidadeEmprestimosAtivos(){
        return this.emprestimosAtivos.size();
    }

    public int getQuantidadeEmprestimosHistorico(){
        return this.emprestimosHistorico.size();
    }

    public int getQuantidadeReservas(){
        return this.reservas.size();
    }

    public int getLimiteTempoEmprestimo() {
        return this.limiteTempoEmprestimo;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo){
        this.emprestimosAtivos.add(emprestimo);
        this.emprestimosHistorico.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo){
        this.emprestimosAtivos.remove(emprestimo);
    }

    public void adicionarReserva(Reserva reserva) throws Exception{
        if (this.reservas.size() == 3)
            throw new Exception(String.format(
                "O usuário '%s' não pode reservar o livro '%s' pois já atingiu seu limite de reservas",
                this.nome,
                reserva.getLivro().getTitulo()
            ));

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
