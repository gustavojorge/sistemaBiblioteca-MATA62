package src.sistema;

import src.comandos.*;
import src.sistema.entradaUsuario.CarregadorArgs;

import java.util.HashMap;

public class ExecutarSistema {
    //Classe "entrada" do exemplo dado em sala
    private HashMap<String, IComando> comandos = new HashMap<String, IComando>();

    public ExecutarSistema(){
        comandos.put(CodigosComandosEnum.EMPRESTIMO_CODIGO.getCodigo(), Fabrica.obterFazerEmprestimoComando());
        comandos.put(CodigosComandosEnum.RESERVA_CODIGO.getCodigo(), Fabrica.obterFazerReservaComando());
        comandos.put(CodigosComandosEnum.CONSULTARLIVRO_CODIGO.getCodigo(), Fabrica.obterConsultarLivroComando());
        comandos.put(CodigosComandosEnum.DEVOLVERLIVRO_CODIGO.getCodigo(), Fabrica.obterDevolverLivroComando());
        comandos.put(CodigosComandosEnum.CONSULTARUSUARIO_CODIGO.getCodigo(), Fabrica.obterConsultarUsuarioComando());
        comandos.put(CodigosComandosEnum.CONSULTAROBSERVADOR_CODIGO.getCodigo(), Fabrica.obterConsultarObservadorComando());
        comandos.put(CodigosComandosEnum.OBSERVADOR_CODIGO.getCodigo(), Fabrica.obterObservadorComando());
        comandos.put(CodigosComandosEnum.SAIDA_CODIGO.getCodigo(), Fabrica.sair());
    }   

    public void executarComando(CarregadorArgs args){
        comandos.get(args.getArgumento1()).executar(args);
    }
}
