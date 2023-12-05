package src.comandos;

import src.comandos.comandosCadastrados.*;

public class Fabrica {
    public static IComando obterFazerRevervaComando(){return new FazerEmprestimoComando();}
    public static IComando obterFazerEmprestimoComando(){return new FazerEmprestimoComando();}
    public static IComando obterConsultarLivroComando(){return new ConsultarLivroComando();}
    public static IComando obterConsultarProfessorComando(){return new ConsultarObservadorComando();}
    public static IComando obterConsultarUsuarioComando(){return new ConsultarLivroComando();}
    public static IComando obterDevolverLivroComando(){return new DevolverLivroComando();}
    public static IComando obterObservadorComando(){return new ObservadorComando();}
    public static IComando exit(){return new ExitComando();}
}
