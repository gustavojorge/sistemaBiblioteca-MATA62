package src.comandos.comandosCadastrados;

import src.utils.FachadaSingleton;
import src.comandos.IComando;
import src.utils.entradaUsuario.CarregadorArgs;

public class ExitComando implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.sair();
    }
}
