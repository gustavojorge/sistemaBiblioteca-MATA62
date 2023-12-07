package src.comandos.comandosCadastrados;

import src.comandos.IComando;
import src.fachada.FachadaSingleton;
import src.sistema.entradaUsuario.CarregadorArgs;

public class ConsultarLivroComando implements IComando {
    public void executar(CarregadorArgs args) {
        String codigoLivro = args.getArgumento2();

        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.ConsultarLivro(codigoLivro);
    }
}
