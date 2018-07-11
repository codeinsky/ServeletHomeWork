package a;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user = req.getParameter("UserName");
		String password = req.getParameter("Password");
		
		if (user.equals("alex")){
			RequestDispatcher ds1 = req.getRequestDispatcher("Welcome");
			ds1.forward(req, resp);
			HttpSession session = req.getSession();
			 if (session!=null) {
				 session.invalidate();
			 }
			
		}
		
		else
			{RequestDispatcher ds2 = req.getRequestDispatcher("Sorry");
			ds2.forward(req,resp );
			
			
		}
	}
	

}
