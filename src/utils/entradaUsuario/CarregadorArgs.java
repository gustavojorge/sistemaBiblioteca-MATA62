package src.utils.entradaUsuario;

public class CarregadorArgs {
    public String argumento1; //codigo
    public String argumento2;
    public String argumento3;

    public CarregadorArgs(String entrada){
        TratamentoEntrada tratamentoEntrada = new TratamentoEntrada(entrada);
        this.argumento1 = tratamentoEntrada.getArgumento1();
        this.argumento2 = tratamentoEntrada.getArgumento2();
        this.argumento3 = tratamentoEntrada.getArgumento3();
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
