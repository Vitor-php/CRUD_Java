package DAO;

import DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UsuarioDAO {

    Connection conexao;

    public ResultSet autenticacaoUsuario(UsuarioDTO ObjUsuarioDto) {
        conexao = new ConexaoDAO().conectaBD();

        try {
            // validação se a senha e o login existem no banco de dados
            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ? ";
            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, ObjUsuarioDto.getNome_usuario());
            pstm.setString(2, ObjUsuarioDto.getSenha_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + error);
            return null;
        }

    }
}
