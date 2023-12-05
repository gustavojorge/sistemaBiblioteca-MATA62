package src;

import src.utils.entradaUsuario.CarregadorArgs;
import src.utils.ExecutarSistema;

public class main {
    String entradaUsuario = "emp 123 100";

    //Carregando os argumentos a partir da entrada do usuário
    CarregadorArgs entradaProcessada = new CarregadorArgs(entradaUsuario);

    //Executando a solicitacao do usuario
    ExecutarSistema executar = new ExecutarSistema(entradaProcessada);

}
