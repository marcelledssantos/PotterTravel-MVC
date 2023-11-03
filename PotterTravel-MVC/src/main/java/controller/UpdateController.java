package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idCliente = Integer.parseInt(req.getParameter("id"));
		ClienteDAO cdao = new ClienteDAO();
		Cliente clienteSelecionado = cdao.getClienteById(idCliente);
		req.setAttribute("cliente", clienteSelecionado);

		RequestDispatcher rd = req.getRequestDispatcher("/atualizar.jsp");

		rd.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cliente clienteAlterado = new Cliente();
	
		clienteAlterado.setNome(req.getParameter("nome"));
		clienteAlterado.setCpf(req.getParameter("cpf"));
		clienteAlterado.setTelefone(req.getParameter("telefone"));
		clienteAlterado.setEmail(req.getParameter("email"));
		clienteAlterado.setSenha(req.getParameter("senha"));
		clienteAlterado.setId(Integer.parseInt(req.getParameter("id")));
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.update(clienteAlterado);
		resp.sendRedirect("ReadController");
	}

}