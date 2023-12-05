package src.comandos;

public enum CodigosComandosEnum {
    EMPRESTIMO_CODIGO("emp"),
    RESERVA_CODIGO("res"),
    CONSULTARLIVRO_CODIGO("liv"),
    CONSULTARPROFESSOR_CODIGO("nft"),
    CONSULTARUSUARIO_CODIGO("usu"),
    DEVOLVERLIVRO_CODIGO("dev"),
    OBSERVADOR_CODIGO("obs"),
    EXIT_CODIGO("sai");

    private final String codigo;

    CodigosComandosEnum(String codigo){
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

}
