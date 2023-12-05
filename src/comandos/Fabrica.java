package src.comandos;

import src.comandos.comandosCadastrados.*;

public class Fabrica {
    public static IComando obterFazerReservaComando(){return new FazerReservaComando();}
    public static IComando obterFazerEmprestimoComando(){return new FazerEmprestimoComando();}
    public static IComando obterConsultarLivroComando(){return new ConsultarLivroComando();}
    public static IComando obterConsultarObservadorComando(){return new ConsultarObservadorComando();}
    public static IComando obterConsultarUsuarioComando(){return new ConsultarUsuarioComando();}
    public static IComando obterDevolverLivroComando(){return new DevolverLivroComando();}
    public static IComando obterObservadorComando(){return new ObservadorComando();}
    public static IComando sair(){return new ExitComando();}
}
