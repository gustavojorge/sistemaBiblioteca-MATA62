package src.comandos.comandosCadastrados;

import src.comandos.IComando;
import src.fachada.FachadaSingleton;
import src.sistema.entradaUsuario.CarregadorArgs;

public class ConsultarObservadorComando implements IComando {
    public void executar(CarregadorArgs args) {
        String codigoObservador = args.getArgumento2();

        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.ConsultarObservador(codigoObservador);
    }
}
