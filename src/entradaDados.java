package src;

import src.comandos.*;
import src.comandos.CodigosComandosEnum;
import src.utils.CarregadorArgs;

import java.util.HashMap;

public class entradaDados {
    private HashMap<String, IComando> comandos;

    public entradaDados(){
        initComandos();
    }

    private void initComandos(){
        comandos.put(CodigosComandosEnum.EMPRESTIMO_CODIGO.getCodigo(), Fabrica.obterFazerEmprestimoComando());
        comandos.put(CodigosComandosEnum.RESERVA_CODIGO.getCodigo(), Fabrica.obterFazerRevervaComando());
        comandos.put(CodigosComandosEnum.CONSULTARLIVRO_CODIGO.getCodigo(), Fabrica.obterConsultarLivroComando());
        comandos.put(CodigosComandosEnum.DEVOLVERLIVRO_CODIGO.getCodigo(), Fabrica.obterDevolverLivroComando());
        comandos.put(CodigosComandosEnum.CONSULTARUSUARIO_CODIGO.getCodigo(), Fabrica.obterConsultarUsuarioComando());
        comandos.put(CodigosComandosEnum.CONSULTARPROFESSOR_CODIGO.getCodigo(), Fabrica.obterConsultarProfessorComando());
        comandos.put(CodigosComandosEnum.OBSERVADOR_CODIGO.getCodigo(), Fabrica.obterObservadorComando());

        //sair do programa
        comandos.put(CodigosComandosEnum.EXIT_CODIGO.getCodigo(), Fabrica.exit());
    }

    private void executarComandos(String cmd, CarregadorArgs args){
        comandos.get(cmd).executar(args);
    }
}
