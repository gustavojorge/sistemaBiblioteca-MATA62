package src.comandos.comandosCadastrados;

import src.FachadaSingleton;
import src.comandos.IComando;
import src.utils.CarregadorArgs;

public class ConsultarUsuarioComando implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        String codigoUsuario = args.getArgumento2();

        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.ConsultarUsuario(codigoUsuario);
    }
}
