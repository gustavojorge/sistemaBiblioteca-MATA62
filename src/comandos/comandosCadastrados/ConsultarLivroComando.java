package src.comandos.comandosCadastrados;

import src.utils.FachadaSingleton;
import src.comandos.IComando;
import src.utils.entradaUsuario.CarregadorArgs;

public class ConsultarLivroComando implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        String codigoLivro = args.getArgumento2();

        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.ConsultarLivro(codigoLivro);
    }
}
