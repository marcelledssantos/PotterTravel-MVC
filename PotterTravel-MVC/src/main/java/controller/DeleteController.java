package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int idCliente = Integer.parseInt(req.getParameter("id"));

			ClienteDAO cdao = new ClienteDAO();
			cdao.removeById(idCliente);
			
			System.out.println("Cliente Deletado com sucesso!");
			
			resp.sendRedirect("ReadController");
		}

	}