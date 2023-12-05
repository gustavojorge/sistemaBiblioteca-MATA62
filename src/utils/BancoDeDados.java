package src.utils;

import src.usuarios.Usuario;
import src.usuarios.tiposUsuariosCadastrados.AlunoGraduacao;
import src.usuarios.tiposUsuariosCadastrados.AlunoPosGraduacao;
import src.usuarios.tiposUsuariosCadastrados.Professor;
import src.usuarios.verificadoresEmprestimo.VerificadorAluno;
import src.usuarios.verificadoresEmprestimo.VerificadorProfessor;

public class BancoDeDados {

    public BancoDeDados(){
        criarBD();
    }

    private void criarBD(){
        //Usuarios
        Usuario alunoGraduacao = new AlunoGraduacao(123, "João da Silva", new VerificadorAluno());
        Usuario alunoPosGraduacao = new AlunoPosGraduacao(456, "Luiz Fernando Rodrigues", new VerificadorAluno());
        Usuario alunoGraduacao2 = new AlunoGraduacao(789, "Pedro Paulo", new VerificadorAluno());
        Usuario professor = new Professor(100, "Carlos Lucena", new VerificadorProfessor());

        //Livros
        //Livro livro1 = new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", 2000, 6);

    }

}
