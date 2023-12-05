package src.usuarios.tiposUsuariosCadastrados;

import src.observer.Observer;
import src.usuarios.Usuario;
import src.usuarios.verificadoresEmprestimo.regras.TempoEmprestimo;
import src.usuarios.IVerificadorEmprestimo;

public class Professor extends Usuario implements Observer {

    private int contadorNotificacoes = 0;

    public Professor(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        super(id, nome, verificadorEmprestimo);
        this.limiteTempoEmprestimo = TempoEmprestimo.PROFESSOR.getLimite();
    }

    @Override
    public void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo) {
        super.verificadorEmprestimo = verificadorEmprestimo;
    }

    @Override
    public void update() {
        contadorNotificacoes++;
    }
}
