package src.livro;
import java.util.List;

public class Livro {
    public String id;
    public String titulo;
    public String editora;
    public List<String> autores;
    public List<Exemplar> exemplares;
    public int anoPublicacao;
    public int edicao;

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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void adicionarAutor(String autor) {
        this.autores.add(autor);
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
}
