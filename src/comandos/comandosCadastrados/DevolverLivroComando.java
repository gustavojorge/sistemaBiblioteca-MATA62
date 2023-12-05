package src.comandos.comandosCadastrados;

import src.comandos.IComando;
import src.utils.CarregadorArgs;

public class DevolverLivroComando implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        String codigoUsuario = args.getArgumento2();
        String codigoLivro = args.argumento3;
    }
}
