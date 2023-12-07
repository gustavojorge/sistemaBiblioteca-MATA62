package src.sistema;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

import src.livro.Livro;
import src.usuarios.Usuario;
import src.usuarios.tiposUsuariosCadastrados.AlunoGraduacao;
import src.usuarios.tiposUsuariosCadastrados.AlunoPosGraduacao;
import src.usuarios.tiposUsuariosCadastrados.Professor;
import src.usuarios.verificadoresEmprestimo.FabricaVerificadores;

public class BancoDeDados {
    private HashMap<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
    private HashMap<Integer, Livro> livros = new HashMap<Integer, Livro>();
    private static BancoDeDados instancia;

    private BancoDeDados(){
        criarBDTeste();
    }

    private void criarBDTeste(){
        //Usuarios
        usuarios.put(123, new AlunoGraduacao(123, "João da Silva", FabricaVerificadores.obterVerificadorAlunoGraduacao()));
        usuarios.put(456, new AlunoPosGraduacao(456, "Luiz Fernando Rodrigues", FabricaVerificadores.obterVerificadorAlunoPosGraduacao()));
        usuarios.put(789, new AlunoGraduacao(789, "Pedro Paulo", FabricaVerificadores.obterVerificadorAlunoGraduacao()));
        usuarios.put(100, new Professor(100, "Carlos Lucena", FabricaVerificadores.obterVerificadorProfessor()));
        
        //Livros
        livros.put(100, new Livro(100, "Engenharia de Software", "AddisonWesley", arrayAutores("Ian Sommervile"), 2000, 6));
        livros.put(101, new Livro(101, "UML – Guia do Usuário", "Campus", arrayAutores("Grady Booch", "James Rumbaugh", "Ivar Jacobson"), 2000, 7));
        livros.put(200, new Livro(200, "Code Complete", "Microsoft Press", arrayAutores("Steve McConnell"), 2014, 2));
        livros.put(201, new Livro(201, "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", arrayAutores("Robert Martin"), 2002, 1));
        livros.put(300, new Livro(300, "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", arrayAutores("Martin Fowler"), 1999, 1));
        livros.put(301, new Livro(301, "Software Metrics: A Rigorous and Practical Approach", "CRC Press", arrayAutores("Norman Fenton", "James Bieman"), 2014, 3));
        livros.put(400, new Livro(400, "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", arrayAutores("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"), 1994, 1));
        livros.put(401, new Livro(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", arrayAutores("Martin Fowler"), 2003, 3));

        //Exemplares
        int exemplares[] = {100, 100, 101, 200, 201, 300, 300, 400, 400}, id_=1;
        for (int i: exemplares){
            livros.get(i).adicionarExemplar(id_);
            id_++;
        }
    }
    
    private List<String> arrayAutores(String ... autores){
        return Arrays.asList(autores);
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
