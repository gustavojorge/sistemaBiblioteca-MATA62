package src.comandos.comandosCadastrados;

import src.comandos.IComando;
import src.utils.CarregadorArgs;

public class ConsultarLivroComando implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        String codigoLivro = args.getArgumento2();
    }
}
