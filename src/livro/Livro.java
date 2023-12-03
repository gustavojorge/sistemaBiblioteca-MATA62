package src.livro;

import java.util.List;
import src.usuarios.Usuario;

public class Livro {
    private String id;
    private String titulo;
    private String editora;
    private List<String> autores;
    private List<Exemplar> exemplares;
    private List<Reserva> reservas;
    private int anoPublicacao;
    private int edicao;

    public Livro(String id, String titulo, String editora, List<String> autores, int anoPublicacao, int edicao) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
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

    public Exemplar obterExemplarLivre(Usuario usuario) throws Exception{
        Exemplar exemplarLivre = null;
        int exemplaresLivres = 0;
        boolean usuarioReservado = false;

        for (Exemplar exemplar: this.exemplares){
            if (exemplar.disponivel()){
                if (exemplarLivre == null){
                    exemplarLivre = exemplar;
                }
                exemplaresLivres++;
            }
        }

        for (Reserva reserva: this.reservas){
            if (reserva.getUsuario().getId() == usuario.getId()){
                usuarioReservado = true;
                break;
            }
        }
        
        if (exemplarLivre == null)
            throw new Exception("Todos os exemplares já foram emprestados!");
        
        if (exemplaresLivres <= this.reservas.size() && !usuarioReservado)
            throw new Exception("Todos os exemplares livres já foram reservados para outros usuários!");

        return exemplarLivre;
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
    }

    public void removerReserva(Usuario usuario) throws Exception{
        for (Reserva reserva: this.reservas){
            if (reserva.getUsuario().getId() == usuario.getId()){
                usuario.removerReserva(reserva);
                this.reservas.remove(reserva);
                return;
            }
        }

        throw new Exception("Usuário não reservou este livro!");
    }
}
