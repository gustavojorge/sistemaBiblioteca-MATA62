package src.comandos.comandosCadastrados;

import src.comandos.IComando;
import src.utils.CarregadorArgs;

public class ConsultarProfessorComando implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        String codigoProfessor = args.getArgumento2();;
    }
}
