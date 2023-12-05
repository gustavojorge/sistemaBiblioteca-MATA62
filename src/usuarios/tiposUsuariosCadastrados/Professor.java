package src.usuarios.tiposUsuariosCadastrados;

import src.observer.Observer;
import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.regras.TempoEmprestimo;
import src.usuarios.IEmprestimosTempoLimitado;
import src.usuarios.IVerificadorEmprestimo;

public class Professor extends Usuario implements Observer, IEmprestimosTempoLimitado {
    private int limiteTempoEmprestimo;
    private int contadorNotificacoes = 0;

    public Professor(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        super(id, nome, verificadorEmprestimo);
        this.limiteTempoEmprestimo = TempoEmprestimo.PROFESSOR.getLimite();
    }

    public void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo) {
        super.verificadorEmprestimo = verificadorEmprestimo;
    }

    public void update() {
        contadorNotificacoes++;
    }

    public int getLimiteTempoEmprestimo() {
        return this.limiteTempoEmprestimo;
    }
}
