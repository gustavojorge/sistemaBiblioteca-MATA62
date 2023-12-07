package src.comandos.comandosCadastrados;

import src.comandos.IComando;
import src.fachada.FachadaSingleton;
import src.sistema.entradaUsuario.CarregadorArgs;

public class ExitComando implements IComando {
    public void executar(CarregadorArgs args) {
        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.sair();
    }
}
