package src.comandos;

import src.utils.entradaUsuario.CarregadorArgs;

public interface IComando {
    public void executar(CarregadorArgs args);
}
