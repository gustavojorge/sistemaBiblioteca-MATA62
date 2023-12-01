package src.usuarios.tiposCadastrados;

import src.usuarios.Usuario;
import src.usuarios.IVerificadorEmprestimo;

public class AlunoPos extends Usuario {

    public AlunoPos(int id, String nome, IVerificadorEmprestimo verificadorEmprestimo) {
        super(id, nome, 4, verificadorEmprestimo);
    }

    @Override
    public void setVerificadorEmprestimo(IVerificadorEmprestimo verificadorEmprestimo) {
        super.verificadorEmprestimo = verificadorEmprestimo;
    }
}
