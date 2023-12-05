package src.livro;

import java.util.ArrayList;
import java.util.List;

import src.observer.Observer;
import src.observer.Subject;
import src.usuarios.Usuario;

public class Livro implements Subject {
    private String id;
    private String titulo;
    private String editora;
    private List<String> autores;
    private List<Exemplar> exemplares;
    private List<Reserva> reservas;
    private int anoPublicacao;
    private int edicao;

    private ArrayList<Observer> observers;

    public Livro(String id, String titulo, String editora, List<String> autores, int anoPublicacao, int edicao) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
        this.observers = new ArrayList<Observer>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    /*public void setTitulo(String titulo) {
        this.titulo = titulo;
    }*/

    public String getEditora() {
        return editora;
    }

    /*public void setEditora(String editora) {
        this.editora = editora;
    }*/

    public List<String> getAutores() {
        return autores;
    }

    /*public void setAutores(List<String> autores) {
        this.autores = autores;
    }*/

    /*public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }*/

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    /*public void adicionarAutor(String autor) {
        this.autores.add(autor);
    }*/

    /*public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }*/

    public int getEdicao() {
        return edicao;
    }

    /*public void setEdicao(int edicao) {
        this.edicao = edicao;
    }*/

    public List<Reserva> getReservas(){
        return this.reservas;
    }

    public int getQuantidadeReservas(){
        return this.reservas.size();
    }

    public int getQuantidadeExemplaresLivres(){
        int exemplaresLivres = 0;

        for (Exemplar exemplar: this.exemplares){
            if (exemplar.disponivel()){
                exemplaresLivres++;
            }
        }

        return exemplaresLivres;
    }

    public Exemplar obterExemplarLivre() throws Exception{
        for (Exemplar exemplar: this.exemplares){
            if (exemplar.disponivel()){
                return exemplar;
            }
        }

        throw new Exception("Não há exemplares deste livro livres!");
    }

    public void adicionarReserva(Usuario usuario) throws Exception{
        for (Reserva reserva: this.reservas){
            if (reserva.getUsuario().getId() == usuario.getId()){
                throw new Exception("Usuário já reservou este livro!");
            }
        }

        if (reservas.size() >= 2) notifyObservers();

        Reserva reserva = new Reserva(this, usuario);
        usuario.adicionarReserva(reserva);
        reservas.add(reserva);
    }

    public void removerReserva(Usuario usuario){
        for (Reserva reserva: this.reservas){
            if (reserva.getUsuario().getId() == usuario.getId()){
                usuario.removerReserva(reserva);
                this.reservas.remove(reserva);
                return;
            }
        }
    }

    //Padrão observer: livro como subject

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
