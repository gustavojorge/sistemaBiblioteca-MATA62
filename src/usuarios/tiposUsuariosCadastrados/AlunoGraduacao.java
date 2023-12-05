package src.usuarios.tiposUsuariosCadastrados;

import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.regras.LimiteEmprestimos;
import src.usuarios.verificadoresEmprestimo.regras.TempoEmprestimo;
import src.usuarios.IEmprestimosLimitados;
import src.usuarios.IVerificadorEmprestimo;

public class AlunoGraduacao extends Usuario implements IEmprestimosLimitados {
    private int limiteQuantidadeEmprestimo;

    public AlunoGraduacao(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        super(id, nome, verificadorEmprestimo);
        this.limiteQuantidadeEmprestimo = LimiteEmprestimos.ALUNO_GRADUACAO.getLimite();
        this.limiteTempoEmprestimo = TempoEmprestimo.ALUNO_GRADUACAO.getLimite();
    }

    public void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo) {
        this.verificadorEmprestimo = verificadorEmprestimo;
    }

    public int getLimiteQuantidadeEmprestimos(){
        return this.limiteQuantidadeEmprestimo;
    }
}
