package src.usuarios.verificadoresEmprestimo;

import src.usuarios.IVerificadorEmprestimo;

public class FabricaVerificadores {
    public static IVerificadorEmprestimo obterVerificadorAlunoGraduacao(){
        return new VerificadorAluno();
    }

    public static IVerificadorEmprestimo obterVerificadorAlunoPosGraduacao(){
        return new VerificadorAluno();
    }

    public static IVerificadorEmprestimo obterVerificadorProfessor(){
        return new VerificadorProfessor();
    }
}
