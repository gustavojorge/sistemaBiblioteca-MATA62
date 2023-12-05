package src.utils;

import src.comandos.*;
import src.utils.entradaUsuario.CarregadorArgs;

import java.util.HashMap;

public class ExecutarSistema {
    //Classe "entrada" do exemplo dado em sala
    private HashMap<String, IComando> comandos;

    public ExecutarSistema(CarregadorArgs args){
        comandos.put(CodigosComandosEnum.EMPRESTIMO_CODIGO.getCodigo(), Fabrica.obterFazerEmprestimoComando());
        comandos.put(CodigosComandosEnum.RESERVA_CODIGO.getCodigo(), Fabrica.obterFazerRevervaComando());
        comandos.put(CodigosComandosEnum.CONSULTARLIVRO_CODIGO.getCodigo(), Fabrica.obterConsultarLivroComando());
        comandos.put(CodigosComandosEnum.DEVOLVERLIVRO_CODIGO.getCodigo(), Fabrica.obterDevolverLivroComando());
        comandos.put(CodigosComandosEnum.CONSULTARUSUARIO_CODIGO.getCodigo(), Fabrica.obterConsultarUsuarioComando());
        comandos.put(CodigosComandosEnum.CONSULTARPROFESSOR_CODIGO.getCodigo(), Fabrica.obterConsultarProfessorComando());
        comandos.put(CodigosComandosEnum.OBSERVADOR_CODIGO.getCodigo(), Fabrica.obterObservadorComando());

        //sair do programa
        comandos.put(CodigosComandosEnum.EXIT_CODIGO.getCodigo(), Fabrica.exit());
        executarComandos(args.getArgumento1(), args);
    }   

    private void executarComandos(String cmd, CarregadorArgs args){
        comandos.get(cmd).executar(args);
    }
}
