package br.com.rd.CrudUsuario.web;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.util.List;

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
		private UserDAO userDao;
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
		userDao = new UserDAO();
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
			insertUser(request, response);
			break;
		
		case "/delete":
			deleteUser(request, response);
			break;
		
		case "/edit":
			showEditForm(request, response);
			break;

		case "/update":
			updateUser(request, response);
			break;
			
			default:
			listUser(request, response);
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
		
		private void deleteUser(HttpRequest request, HttpServletResponse response) throws SQLException, IOException
		{
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				userDao.deleteUser(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("list");
		}
		
		private void showEditForm(HttpRequest request, HttpServletResponse response) throws SQLException, IOException, ServeletException
		{
			int id = Integer.parseInt(request.getParameter("id"));
			User existingUser;
			try {
				existingUser = userDao.selectUser(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
				request.setAttribute("user", existingUser);
				dispatcher.forward(request, response);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		private void updateUser(HttpRequest request, HttpServletResponse response) throws SQLException, IOException
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String nome =request.getParameter("nome");
			String email =request.getParameter("email");
			String pais =request.getParameter("pais");
			
			User user = new User (id, nome, email, pais);
			userDao.updateUser(user);
			response.sendRedirect("list");
			
		}
		
		private void listUser(HttpRequest request, HttpServletResponse response) throws SQLException, IOException
		{
			try {
				List<User> listUser = userDao.selectAllUsers();
				request.setAttribute("listUser", listUser);
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
}