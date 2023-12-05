package src.comandos.comandosCadastrados;

import src.FachadaSingleton;
import src.comandos.IComando;
import src.utils.CarregadorArgs;

public class ExitComando implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.sair();
    }
}
