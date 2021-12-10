package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.Producto;
import Entities.Usuario;
import Logic.LogicProducto;
import Logic.Login;

/**
 * Servlet implementation class Signin
 */
@WebServlet({ "/Signin", "/SIGNIN", "/signin" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salida = request.getParameter("salida");
		switch(salida) {
		case "salir":
			HttpSession cerrarSesion=request.getSession(false);
			if(cerrarSesion != null )
			{
			cerrarSesion.setAttribute("usuario", null);
			cerrarSesion.invalidate();
			}
			request.getRequestDispatcher("/login.html").forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usu = new Usuario();
		Login ctrl = new Login();
		LogicProducto ctrlProd = new LogicProducto();
		
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("contrasenia");
		
		// validar email y password
		
		usu.setEmail(email);
		usu.setContrasenia(contrasenia);
		
		usu=ctrl.validate(usu);
		// usu = request.getSession().getAttribute("usuario",usu); 
		if(usu==null) {
			request.setAttribute("Errormesaje","Usuario y/o contraseña no encontrados");
			request.setAttribute("returnPage", "login.html");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else if(usu != null) {
			// request.getSession(false); Pregunto por session creada o no
		HttpSession sesion = request.getSession();
		sesion.setAttribute("usuario", usu);
		LinkedList<Producto> Producto = ctrlProd.getAll();
		request.setAttribute("listaProductos", Producto);
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		}
		
	}

}
