package src.comandos.comandosCadastrados;

import src.utils.FachadaSingleton;
import src.comandos.IComando;
import src.utils.entradaUsuario.CarregadorArgs;

public class FazerReservaComando implements IComando {
    public void executar(CarregadorArgs args) {
        String codigoUsuario = args.getArgumento2();
        String codigoLivro = args.getArgumento3();

        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.FazerReserva(codigoUsuario, codigoLivro);
    }
}
