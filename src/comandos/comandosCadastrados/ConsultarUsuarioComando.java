package src.comandos.comandosCadastrados;

import src.comandos.IComando;
import src.fachada.FachadaSingleton;
import src.sistema.entradaUsuario.CarregadorArgs;

public class ConsultarUsuarioComando implements IComando {
    public void executar(CarregadorArgs args) {
        String codigoUsuario = args.getArgumento2();

        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.ConsultarUsuario(codigoUsuario);
    }
}
