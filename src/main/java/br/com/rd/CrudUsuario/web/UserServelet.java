package br.com.rd.CrudUsuario.web;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rd.CrudUsuario.bean.User;
import br.com.rd.CrudUsuario.dao.UserDAO;

/**
 * Servlet implementation class UserServelet
 */
@WebServlet("/UserServelet")
public class UserServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserServelet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action)
		{
		case "/new":
			showNewForm(request, response);
			break;
		
		case "/insert":
			break;
		
		case "/delete":
			break;
		
		case "/edit":
			break;

		case "/update":
			break;
			
			default:
			break;
		}
		}
	
		private void showNewForm(HttpRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			dispatcher.forward(request, response);
		}
		
		private void insertUser(HttpRequest request, HttpServletResponse response) throws SQLException, IOException
		{
			String nome =  request.getParameter("nome");
			String email = request.getParameter("email");
			String pais =  request.getParameter("pais");
			 
			User newUser = new User(nome, email, pais);
				
				UserDAO.insertUser(newUser);
			response.sendRedirect("list");
		}
		
	}


