package src.usuarios;

public abstract class Usuario {
    protected int id;
    protected String nome;
    protected int tempoMaxEmprestimo;
    protected IVerificadorEmprestimo verificadorEmprestimo;

    public Usuario(int id, String nome, int tempoMaxEmprestimo, IVerificadorEmprestimo verificadorEmprestimo) {
        this.id = id;
        this.nome = nome;
        this.tempoMaxEmprestimo = tempoMaxEmprestimo;
        this.verificadorEmprestimo = verificadorEmprestimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int identificacao) {
        this.id = identificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoMaxEmprestimo() {
        return tempoMaxEmprestimo;
    }

    public abstract void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo);
}
