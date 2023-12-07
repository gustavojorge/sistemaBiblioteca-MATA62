package src.usuarios.observador;

public interface Subject {
    public void RegistrarObservador(Observador observador);
    public void removerObservador(Observador observador);
    public void notificarObservadores();
}
