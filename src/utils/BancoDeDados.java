package src.utils;

import java.util.HashMap;

import src.livro.Livro;
import src.usuarios.Usuario;
import src.usuarios.tiposUsuariosCadastrados.AlunoGraduacao;
import src.usuarios.tiposUsuariosCadastrados.AlunoPosGraduacao;
import src.usuarios.tiposUsuariosCadastrados.Professor;
import src.usuarios.verificadoresEmprestimo.VerificadorAluno;
import src.usuarios.verificadoresEmprestimo.VerificadorProfessor;

public class BancoDeDados {
    private HashMap<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
    private HashMap<Integer, Livro> livros = new HashMap<Integer, Livro>();
    private static BancoDeDados instancia;

    private BancoDeDados(){
        criarBDTeste();
    }

    private void criarBDTeste(){
        //Usuarios
        usuarios.put(123, new AlunoGraduacao(123, "João da Silva", new VerificadorAluno()));
        usuarios.put(456, new AlunoPosGraduacao(456, "Luiz Fernando Rodrigues", new VerificadorAluno()));
        usuarios.put(789, new AlunoGraduacao(789, "Pedro Paulo", new VerificadorAluno()));
        usuarios.put(100, new Professor(100, "Carlos Lucena", new VerificadorProfessor()));
        
        //Livros
        //Livro livro1 = new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", 2000, 6);
        
    }
    
    public static BancoDeDados obterInstanciaBancoDeDados(){
        if (instancia == null){
            instancia = new BancoDeDados();
        }

        return instancia;
    }

    public Usuario obterUsuarioPorId(int id){
        return usuarios.get(id);
    }

    public Livro obterLivroPorId(int id){
        return livros.get(id);
    }
}
