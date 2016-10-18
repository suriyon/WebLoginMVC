package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserDAO dao = new UserDAO();
		boolean result = dao.checkLogin(user);
		if(result){
			RequestDispatcher rd = request.getRequestDispatcher("user.jsp");			
			request.setAttribute("username", username);
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			String msg = "ล็อคอินไม่สำเร็จ ตรวจสอบ username และ password ใหม่";
			request.setAttribute("msg", msg);
			rd.forward(request, response);
		}
	}

}
