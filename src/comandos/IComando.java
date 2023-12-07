package src.comandos;

import src.sistema.entradaUsuario.CarregadorArgs;

public interface IComando {
    public void executar(CarregadorArgs args);
}
