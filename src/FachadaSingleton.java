package src;

public class FachadaSingleton {
    private static FachadaSingleton instancia;

    private FachadaSingleton() {};

    public static FachadaSingleton obterInstancia() {
        if (instancia == null) {
            instancia = new FachadaSingleton();
        }
        return instancia;
    }

    public void FazerEmprestimo(String codigoUsuario, String codigoLivro){

    }

    public void FazerReserva(String codigoUsuario, String codigoLivro){

    }

    public void ConsultarLivro(String codigoLivro){

    }

    public void ConsultarProfessor(String codigoProfessor){

    }

    public void ConsultarUsuario(String codigoUsuario){

    }

    public void DevolverLivro(String codigoUsuario, String codigoLivro){

    }

    public void tornarObservador(String codigoUsuario, String codigoLivro){

    }

    public void sair(){

    }
}
