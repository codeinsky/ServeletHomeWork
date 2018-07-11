package a;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import db.StoreItems;
import helpers.ShppingCart;

/**
 * Servlet implementation class Controller
 */
@WebServlet(
		urlPatterns = { "/Controller" }, 
		initParams = { 
				@WebInitParam(name = "email", value = "support@online.store")
		})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String supportMail;
	private int hit;
	private StoreItems store;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello from Init ");
		super.init(config);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello from Service");
		String command = req.getParameter("command");
		System.out.println(command);
		if (command  == "startShopping") {
			HttpSession session = req.getSession();
			if (session.isNew()){
				ShppingCart cart = new ShppingCart();
				session.setAttribute("cart", cart);
			}
		
		} 
		
		if (command == "clear") {
			HttpSession sessionClear = req.getSession(false);
			ShppingCart cartSession = (ShppingCart) sessionClear.getAttribute("cart");
			cartSession.clearCart();
			
		}
		else {
		RequestDispatcher ds = req.getRequestDispatcher("ViewManager");
		ds.forward(req, resp);
		}
	}
	
	
	
}
