package src.usuarios.verificadoresEmprestimo.regras;

public enum LimiteEmprestimos {
    ALUNO_GRADUACAO(3),
    ALUNO_POS_GRADUACAO(4);

    private final int quantidadeLivros;
    
    LimiteEmprestimos(int quantidadeLivros){
        this.quantidadeLivros = quantidadeLivros;
    }

    public int getLimite() {
        return this.quantidadeLivros;
    }
}
