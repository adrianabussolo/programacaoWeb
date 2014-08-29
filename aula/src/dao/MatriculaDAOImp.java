package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Matricula;


import conexao.ConnectionManager;

public class MatriculaDAOImp implements MatriculaDAO {

	private final String INSERT = "insert into Matricula ( nome, curso, dataNascimento, cpf, endereco) values (?,?,?,?,?)";
	private final String UPDATE = "update matricula set  nome = ?, curso = ?, dataNascimento = ? where idMatricula = ?";
	private final String DELETE = "delete from matricula where idmatricula = ?";
	private final String ALL = "select * from matricula";
	private final String CURSO = "select * from MATRICULA where curso = ?";

	private static Connection connection;

	public MatriculaDAOImp() {
		openConnection();
	}

	
	
	@Override
	public Matricula salvar (Matricula e) {
		try {
			PreparedStatement ps = null;

			ps = ConnectionManager.getInstance().getConnection()
					.prepareStatement(INSERT);

			ps.setObject(1, e.getNome());
			ps.setObject(2, e.getCurso());
			ps.setObject(3, e.getDataNascimento());
			ps.setObject(4, e.getCpf());
			ps.setObject(5, e.getEndereco());
			

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(MatriculaDAOImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
		return e;
	}

	@Override
	public void alterar(Matricula e) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(UPDATE);

			ps.setObject(1, e.getNome());
			ps.setObject(2, e.getCurso());
			ps.setObject(3, e.getDataNascimento());
			ps.setObject(4, e.getCpf());
			

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(MatriculaDAOImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
	}

	@Override
	public void deletar(Matricula e) {
		try {
			PreparedStatement ps = null;
			ps = connection.prepareStatement(DELETE);

			ps.setObject(1, e.getIdmatricula());

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(MatriculaDAOImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
	}

	@Override
	public List<Matricula> findAll() {
		List<Matricula> matriculas = new ArrayList<Matricula>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = connection.prepareStatement(ALL);

			rs = ps.executeQuery();

			while (rs.next()) {
				modelo.Matricula matricula = new Matricula();
				matricula.setIdmatricula(rs.getInt("idmatricula"));
				matricula.setNome(rs.getString("nome"));
				matricula.setCurso(rs.getString("curso"));
				//matricula.setDataNascimento(rs.getString("dataNascimento"));
				matricula.setCpf(rs.getInt("cpf"));
				
			}

		} catch (SQLException ex) {
			Logger.getLogger(MatriculaDAOImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}
		return matriculas;
	}

	@Override
	public List<Matricula> buscarPorNomeCurso(String nome) {
		List<Matricula> matriculas = new ArrayList<Matricula>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = connection.prepareStatement(nome);
			ps.setObject(1, nome);

			rs = ps.executeQuery();

			while (rs.next()) {
				Matricula matricula = new Matricula();
				matricula.setIdmatricula(rs.getInt("idmatricula"));
				matricula.setNome(rs.getString("nome"));
				matricula.setCurso(rs.getString("curso"));
				//matricula.setDataNascimento(rs.getString("dataNascimento"));
				matricula.setCpf(rs.getInt("cpf"));
				
				
			}

		} catch (SQLException ex) {
			Logger.getLogger(MatriculaDAOImp.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			this.closeConnection();
		}

		return matriculas;

	}

	@Override
	public boolean isConnectionClose() {
		try {
			return connection.isClosed();
		} catch (SQLException ex) {
			return false;
		}
	}

	@Override
	public void openConnection() {
		if (connection == null) {
			connection = ConnectionManager.getInstance().getConnection();
		}

		if (isConnectionClose()) {
			connection = ConnectionManager.getInstance().getConnection();
		}
	}

	@Override
	public void closeConnection() {
		if (connection != null && !this.isConnectionClose()) {
			ConnectionManager.getInstance().closeConnection(connection);
		}

	}

	
	

	
	

}

