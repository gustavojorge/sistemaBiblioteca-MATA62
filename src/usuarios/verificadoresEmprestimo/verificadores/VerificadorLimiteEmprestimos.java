package src.usuarios.verificadoresEmprestimo.verificadores;

import src.usuarios.Usuario;

// Verifica se o usuário atingiu seu limite de empréstimos
public class VerificadorLimiteEmprestimos {
    public static boolean usuarioEValido(Usuario usuario){
        if (usuario.getQuantidadeEmprestimosAtivos() >= usuario.getLimiteQuantidadeEmprestimos())
            return false;

        return true;
    }
}
