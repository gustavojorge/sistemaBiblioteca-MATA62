package src.usuarios.verificadoresEmprestimo;

import src.usuarios.IVerificadorEmprestimo;

public class VerificadorProfessor implements IVerificadorEmprestimo {

    @Override
    public Boolean verificadorEmprestimo() {
        return true;
    }
}
