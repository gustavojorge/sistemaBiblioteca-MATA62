package src.usuarios.verificadoresEmprestimo.verificadores;

import src.usuarios.IEmprestimosLimitados;
import src.usuarios.Usuario;

// Verifica se o usuário ainda não atingiu seu limite de empréstimos
public class VerificadorLimiteEmprestimos {
    public static boolean usuarioEValido(Usuario usuario){
        IEmprestimosLimitados usuario_ = (IEmprestimosLimitados) usuario;

        if (usuario.getQuantidadeEmprestimosAtivos() >= usuario_.getLimiteQuantidadeEmprestimos())
            return false;

        return true;
    }
}
