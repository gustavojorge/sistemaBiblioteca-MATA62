package src.utils;

import src.utils.entradaUsuario.CarregadorArgs;

public class Console {
    //Instânciando exemplos na memória -> simulando um banco de dados
    BancoDeDados bancoDeDados = BancoDeDados.obterInstanciaBancoDeDados();

    //Carregando os argumentos a partir da entrada do usuário
    //CarregadorArgs entradaProcessada = new CarregadorArgs(entradaUsuario);

    //Executando a solicitacao do usuario
    //ExecutarSistema executar = new ExecutarSistema(entradaProcessada);

    public static void imprimirMensagem(String msg){
        System.out.println(msg);
    }

    public static void imprimirMensagem(String msg, boolean quebrarLinha){
        String quebra = (quebrarLinha)?"\n":"";
        System.out.print(msg+quebra);
    }

    public static void imprimirMensagem(String msg, Object ... args){
        System.out.printf(msg, args);
    }
}
