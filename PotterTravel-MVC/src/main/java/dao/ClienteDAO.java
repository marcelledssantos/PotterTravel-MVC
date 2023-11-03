package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connectionDataBase.ConnectionDataBase;
import model.Cliente;
	
public class ClienteDAO {
	
	public void createCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente(nome, cpf, telefone, email, senha)" + "VALUES(?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {

			conn = ConnectionDataBase.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getSenha());
			pstm.execute();
			
			System.out.println("Cliente criado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Cliente findCliente(int id) {
		
		Cliente cliente= null;
	  String sql = "SELECT * FROM Cliente WHERE id=?";
	
			Connection conn = null;
			PreparedStatement pstm = null;

			ResultSet rset = null;
			
			try {
				try {
					conn = ConnectionDataBase.createConnectionToMySQL();
					pstm = conn.prepareStatement(sql);
					rset = pstm.executeQuery();

				while (rset.next()) {
					cliente = new Cliente();
					cliente.setId(rset.getInt("id"));
					cliente.setNome(rset.getString("nome"));
					cliente.setCpf(rset.getString("cpf"));
					cliente.setTelefone(rset.getString("telefone"));
					cliente.setEmail(rset.getString("email"));
					cliente.setSenha(rset.getString("senha"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rset != null) {
						rset.close();
					}
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			} finally {
				
			}
			return cliente;
			
		}
	public List<Cliente> findClientes() {
		
		String sql = "SELECT * FROM Cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionDataBase.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(rset.getInt("id"));
				cliente.setNome(rset.getString("nome"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setTelefone(rset.getString("telefone"));
				cliente.setEmail(rset.getString("email"));
				cliente.setSenha(rset.getString("senha"));
				clientes.add(cliente);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clientes;
	}
	
	public void update(Cliente cliente) {
		
		String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, email = ?, senha = ? "
				+ "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			
		conn = ConnectionDataBase.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, cliente.getNome());
		pstm.setString(2, cliente.getCpf());
		pstm.setString(3, cliente.getTelefone());
		pstm.setString(4, cliente.getEmail());
		pstm.setString(5, cliente.getSenha());
		pstm.setInt(6, cliente.getId());
		pstm.execute();
		
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	public Cliente getClienteById(int id) {

		String sql = "SELECT *FROM  cliente WHERE id = ?";
		Cliente cliente = new Cliente();
		
		ResultSet rset= null;
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
		
			conn = ConnectionDataBase.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();
			
			cliente.setNome(rset.getString("nome"));
			cliente.setCpf(rset.getString("cpf"));
			cliente.setTelefone(rset.getString("telefone"));
			cliente.setEmail(rset.getString("email"));
			cliente.setSenha(rset.getString("senha"));
			cliente.setId(rset.getInt("id"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return cliente;
	}
	public void removeById(int id) {
		String sql = "DELETE FROM cliente WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionDataBase.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}

	
	





