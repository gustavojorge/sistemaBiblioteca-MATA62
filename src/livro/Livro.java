package src.livro;

import java.util.ArrayList;
import java.util.List;

import src.observador.Observador;
import src.observador.Subject;
import src.usuarios.Usuario;

public class Livro implements Subject {
    private int id;
    private String titulo;
    private String editora;
    private List<String> autores;
    private List<Exemplar> exemplares = new ArrayList<Exemplar>();
    private List<Reserva> reservas = new ArrayList<Reserva>();
    private List<Observador> observadores = new ArrayList<Observador>();
    private int anoPublicacao;
    private int edicao;
    
    public Livro(int id, String titulo, String editora, List<String> autores, int anoPublicacao, int edicao) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getEditora() {
        return editora;
    }
    
    public List<String> getAutores() {
        return autores;
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public int getEdicao() {
        return edicao;
    }
    
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
    
    public int getQuantidadeTotalExemplares(){
        return exemplares.size();
    }
    
    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void adicionarExemplar(int id){
        exemplares.add(new Exemplar(this, id));
    }
    
    public Exemplar obterExemplarLivre() throws Exception{
        for (Exemplar exemplar: this.exemplares){
            if (exemplar.disponivel()){
                return exemplar;
            }
        }

        throw new Exception("Não há exemplares livres deste livro!");
    }

    public void adicionarReserva(Usuario usuario) throws Exception{
        for (Reserva reserva: this.reservas){
            if (reserva.getUsuario().getId() == usuario.getId()){
                throw new Exception("Usuário já reservou este livro!");
            }
        }

        
        Reserva reserva = new Reserva(this, usuario);
        usuario.adicionarReserva(reserva);
        reservas.add(reserva);

        if (reservas.size() > 2)
            notificarObservadores();
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

    public void RegistrarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (Observador observador: observadores) {
            observador.atualizar();
        }
    }
}
