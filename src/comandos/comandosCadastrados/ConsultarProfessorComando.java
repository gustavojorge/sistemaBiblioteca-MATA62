package src.comandos.comandosCadastrados;

import src.FachadaSingleton;
import src.comandos.IComando;
import src.utils.CarregadorArgs;

public class ConsultarProfessorComando implements IComando {
    @Override
    public void executar(CarregadorArgs args) {
        String codigoProfessor = args.getArgumento2();

        FachadaSingleton fachada = FachadaSingleton.obterInstancia();
        fachada.ConsultarProfessor(codigoProfessor);
    }
}
