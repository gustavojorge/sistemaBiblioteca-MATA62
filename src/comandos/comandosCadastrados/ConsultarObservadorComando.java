package src.comandos.comandosCadastrados;

import src.utils.FachadaSingleton;
import src.comandos.IComando;
import src.utils.entradaUsuario.CarregadorArgs;

public class ConsultarObservadorComando implements IComando {
    public void executar(CarregadorArgs args) {
        String codigoObservador = args.getArgumento2();

        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.ConsultarObservador(codigoObservador);
    }
}
