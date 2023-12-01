package src.usuarios.tiposCadastrados;

import src.usuarios.Usuario;
import src.usuarios.IVerificadorEmprestimo;

public class AlunoGrad extends Usuario {

    public AlunoGrad(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        super(id, nome, 3, verificadorEmprestimo);
    }

    @Override
    public void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo) {
        super.verificadorEmprestimo = verificadorEmprestimo;
    }
}
