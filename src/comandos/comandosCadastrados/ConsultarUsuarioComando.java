package src.comandos.comandosCadastrados;

import src.utils.FachadaSingleton;
import src.comandos.IComando;
import src.utils.entradaUsuario.CarregadorArgs;

public class ConsultarUsuarioComando implements IComando {
    public void executar(CarregadorArgs args) {
        String codigoUsuario = args.getArgumento2();

        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.ConsultarUsuario(codigoUsuario);
    }
}
