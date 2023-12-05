package src.usuarios.tiposUsuariosCadastrados;

import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.regras.LimiteEmprestimos;
import src.usuarios.verificadoresEmprestimo.regras.TempoEmprestimo;
import src.usuarios.IVerificadorEmprestimo;

public class AlunoGraduacao extends Usuario {

    public AlunoGraduacao(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        super(id, nome, verificadorEmprestimo);
        this.limiteQuantidadeEmprestimo = LimiteEmprestimos.ALUNO_GRADUACAO.getLimite();
        this.limiteTempoEmprestimo = TempoEmprestimo.ALUNO_GRADUACAO.getLimite();
    }

    @Override
    public void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo) {
        super.verificadorEmprestimo = verificadorEmprestimo;
    }
}
