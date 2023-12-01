package src.usuarios.tiposCadastrados;

import src.usuarios.Usuario;
import src.usuarios.IVerificadorEmprestimo;

public class Professor extends Usuario {

    public Professor(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        super(id, nome, 7, verificadorEmprestimo);
    }

    @Override
    public void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo) {
        super.verificadorEmprestimo = verificadorEmprestimo;
    }
}
