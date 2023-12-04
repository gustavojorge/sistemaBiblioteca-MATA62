package src.usuarios;

import src.livro.Livro;

public interface IVerificadorEmprestimo {
    
    public boolean verificadorEmprestimo(Usuario usuario, Livro livro);
}
