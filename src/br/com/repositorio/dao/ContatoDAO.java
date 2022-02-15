package br.com.repositorio.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.repositorio.db.ConexaoBD;
import Classes.Repositorio;


	public class ContatoDAO {

	
		private static Connection conexao = null;
		private static PreparedStatement sql = null;
		private static ResultSet rset = null;
		
		//C
		public static boolean incluir(Repositorio contato) {
			boolean erro = false;
			Repositorio repositorio=new Repositorio();
			if(repositorio.getDisciplina()==1) {
				String insert = "INSERT	INTO LELP (assunto,autor, descricao, link) VALUES (?, ?, ?,?)";
				
				try {
					conexao = ConexaoBD.getConexaoMySQL();
					sql = conexao.prepareStatement(insert);
					sql.setString(1, contato.getAssuntoLELP());
					sql.setString(2, contato.getAutor());
					sql.setString(3, contato.getDescricao());
					sql.setString(4, contato.getLink());
					sql.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					erro = true;
				} finally {
					fecharConexao();
				}
				return erro;
			}
			
			if(repositorio.getDisciplina()==2) {
				String insert = "INSERT	INTO estrutura (assunto,autor, descricao, link) VALUES (?, ?, ?,?)";
				
				try {
					conexao = ConexaoBD.getConexaoMySQL();
					sql = conexao.prepareStatement(insert);
					sql.setString(1, contato.getAssuntoEstrutura());
					sql.setString(2, contato.getAutor());
					sql.setString(3, contato.getDescricao());
					sql.setString(4, contato.getLink());
					sql.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					erro = true;
				} finally {
					fecharConexao();
				}
				return erro;
			}
			
			if(repositorio.getDisciplina()==3) {
				String insert = "INSERT	INTO POO (assunto,autor, descricao, link) VALUES (?, ?, ?,?)";
				
				try {
					conexao = ConexaoBD.getConexaoMySQL();
					sql = conexao.prepareStatement(insert);
					sql.setString(1, contato.getAssuntoPOO());
					sql.setString(2, contato.getAutor());
					sql.setString(3, contato.getDescricao());
					sql.setString(4, contato.getLink());
					sql.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
					erro = true;
				} finally {
					fecharConexao();
				}
				return erro;
			}
			return erro;

		}
		
		//R
		public static List<Repositorio> listarRepositorio() {
			
			String select = "SELECT * FROM lelp";

			List<Repositorio> contatos = new ArrayList<Repositorio>();

			try {
				conexao = ConexaoBD.getConexaoMySQL();
				sql = conexao.prepareStatement(select);
				rset = sql.executeQuery();

				while (rset.next()) {

					Repositorio contato = new Repositorio();

					
					contato.setAutor(rset.getString("autor"));
					contato.setDescricao(rset.getString("descricao"));
					contato.setLink(rset.getString("link"));

					contatos.add(contato);

				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fecharConexao();
			}
			
			return contatos;
		}
		
		//U
		public static int editar(Repositorio contato) {
			String update = "UPDATE contatos SET assunto= ?, autor = ?, descricao = ?,link=? WHERE id = ?";
			int linha = 0;
			try {
				conexao = ConexaoBD.getConexaoMySQL();
				sql = conexao.prepareStatement(update);
				sql.setString(1, contato.getAssuntoLELP());
				///sql.setString(1, contato.getAssuntoEstrutura());
				///sql.setString(1, contato.getAssuntoPOO());
				sql.setString(2, contato.getAutor());
				sql.setString(3, contato.getDescricao());
				sql.setString(4, contato.getLink());
				linha = sql.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fecharConexao();
			}
			return linha;
		}
		
		//D
		public static boolean apagar(int id) {
			boolean erro = false;
			String delete = "DELETE FROM contatos WHERE id = ?";
			
			try {
				conexao = ConexaoBD.getConexaoMySQL();
				sql = conexao.prepareStatement(delete);
				sql.setInt(1, id);
				sql.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				erro = true;
			} finally {
				fecharConexao();
			}
			return erro;
			
		}
		
		public static Repositorio findById(int id) {
			Repositorio contato = null;

			String select = "SELECT * FROM Repositorio WHERE id = ?";

			try {
				conexao = ConexaoBD.getConexaoMySQL();
				sql = conexao.prepareStatement(select);
				sql.setInt(1, id);

				rset = sql.executeQuery();

				while (rset.next()) {

					contato = new Repositorio();
					
					contato.setAutor(rset.getString("autor"));
					contato.setDescricao(rset.getString("descricao"));
					contato.setLink(rset.getString("link"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fecharConexao();
			}

			return contato;
		}

		private static void fecharConexao() {

			try {

				if (rset != null) {
					rset.close();
				}

				if (sql != null) {
					sql.close();
				}

				if (conexao != null) {
					conexao.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	
