package src.usuarios.tiposUsuariosCadastrados;

import src.usuarios.Usuario;
import src.usuarios.observador.Observador;
import src.usuarios.verificadoresEmprestimo.regras.TempoEmprestimo;
import src.usuarios.IVerificadorEmprestimo;

public class Professor extends Usuario implements Observador{
    private int contadorNotificacoes = 0;

    public Professor(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        super(id, nome, verificadorEmprestimo);
        this.limiteTempoEmprestimo = TempoEmprestimo.PROFESSOR.getLimite();
    }

    public void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo) {
        this.verificadorEmprestimo = verificadorEmprestimo;
    }

    public void atualizar() {
        contadorNotificacoes++;
    }
    
    public int getQuantidadeNotificacoes() {
        return this.contadorNotificacoes;
    }
}
