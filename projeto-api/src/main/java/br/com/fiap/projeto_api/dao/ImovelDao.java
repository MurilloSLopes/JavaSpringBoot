package br.com.fiap.projeto_api.dao;

import br.com.fiap.projeto_api.model.Imovel;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ImovelDao {

    private  final DataSource dataSource;
    private String sql = "INSERT INTO t_api_imovel (cd_imovel, ds_imovel, nr_imovel, vl_imovel) "
            + "VALUES (sq_t_api_imovel.NEXTVAL, ?,?,?)";

    public ImovelDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void inserir(Imovel imovel) throws SQLException {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql,new String[] { "cd_imovel" })) {
            stmt.setString(1, imovel.getDescriacao());
            stmt.setDouble(2, imovel.getDimensao());
            stmt.setDouble(3, imovel.getValor());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                imovel.setId(rs.getInt(1));
            }
        }
    }
}
