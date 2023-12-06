package src.utils;

import java.util.Scanner;
import src.utils.entradaUsuario.CarregadorArgs;

public class Console {
    private ExecutarSistema sistema = new ExecutarSistema();

    public void executar(){
        Scanner entrada = new Scanner(System.in);
        CarregadorArgs argumentos;

        while (true){
            imprimirMensagem("> ", false);
            argumentos = new CarregadorArgs(entrada.nextLine());
            sistema.executarComando(argumentos);
            imprimirMensagem("");
        }
    }

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
