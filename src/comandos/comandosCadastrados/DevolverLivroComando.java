package src.comandos.comandosCadastrados;

import src.FachadaSingleton;
import src.comandos.IComando;
import src.utils.CarregadorArgs;

public class DevolverLivroComando implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        String codigoUsuario = args.getArgumento2();
        String codigoLivro = args.getArgumento3();

        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.DevolverLivro(codigoUsuario, codigoLivro);
    }
}
