package src.usuarios.verificadoresEmprestimo;

import src.usuarios.IVerificadorEmprestimo;

public class VerificadorAluno implements IVerificadorEmprestimo {
    @Override
    public Boolean verificadorEmprestimo() {
        return true;
    }
}
