package src.usuarios.verificadoresEmprestimo;

import src.usuarios.IVerificadorEmprestimo;

public class Fabrica {
    static IVerificadorEmprestimo obterVerificadorAlunoGraduacao(){
        return new VerificadorAluno();
    }

    static IVerificadorEmprestimo obterVerificadorAlunoPosGraduacao(){
        return new VerificadorAluno();
    }

    static IVerificadorEmprestimo obterVerificadorProfessor(){
        return new VerificadorProfessor();
    }
}
