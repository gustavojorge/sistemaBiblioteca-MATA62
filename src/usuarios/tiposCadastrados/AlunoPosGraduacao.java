package src.usuarios.tiposCadastrados;

import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.regras.LimiteEmprestimos;
import src.usuarios.verificadoresEmprestimo.regras.TempoEmprestimo;
import src.usuarios.IVerificadorEmprestimo;

public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        super(id, nome, verificadorEmprestimo);
        this.limiteQuantidadeEmprestimo = LimiteEmprestimos.ALUNO_POS_GRADUACAO.getLimite();
        this.limiteTempoEmprestimo= TempoEmprestimo.ALUNO_POS_GRADUACAO.getLimite();
    }

    @Override
    public void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo) {
        super.verificadorEmprestimo = verificadorEmprestimo;
    }
}
