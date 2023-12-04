package src.usuarios.verificadoresEmprestimo.verificadores;

import src.usuarios.Usuario;

public class VerificadorLimiteEmprestimos {
    public static boolean usuarioEValido(Usuario usuario){
        if (usuario.getQuantidadeEmprestimosAtivos() >= usuario.getLimiteQuantidadeEmprestimos())
            return false;

        return true;
    }
}
