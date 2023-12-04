package src.usuarios.verificadoresEmprestimo.regras;

public enum TempoEmprestimo {
    ALUNO_GRADUACAO(3),
    ALUNO_POS_GRADUACAO(4),
    PROFESSOR(7);

    private final int quantidadeDias;

    TempoEmprestimo(int quantidadeDias){
        this.quantidadeDias = quantidadeDias;
    }

    public int getLimite(){
        return this.quantidadeDias;
    }
}
