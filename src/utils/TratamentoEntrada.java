package src.utils;

public class TratamentoEntrada {

    private String argumento1; //codigo do comando
    private String argumento2;
    private String argumento3;

    public TratamentoEntrada(String entrada){
        processarEntrada(entrada);
    }

    public void processarEntrada(String entrada) {
        String[] argumentos = entrada.split(" ");

        this.argumento1 = (argumentos.length > 0) ? argumentos[0] : "";
        this.argumento2 = (argumentos.length > 1) ? argumentos[1] : "";
        this.argumento3 = (argumentos.length > 2) ? argumentos[2] : "";
    }

    public String getArgumento1() {
        return argumento1;
    }

    public String getArgumento2() {
        return argumento2;
    }

    public String getArgumento3() {
        return argumento3;
    }
}

