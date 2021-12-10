package servlet;


import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.LineaDePedido;
import Entities.Pedido;
import Entities.Producto;
import Entities.Usuario;
import Logic.LogicPedido;
import Logic.Login;

/**
 * Servlet implementation class abmcPedido
 */
@WebServlet("/abmcPedido")
public class abmcPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public abmcPedido() {
        super();
    }
    LogicPedido ctrlped = new LogicPedido();
    Usuario usu = new Usuario();
    LinkedList<Pedido> listaPed = new LinkedList<>();
    Double totalPagar=100.0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		switch (accion) {
		
		 case "generarCompra" :{
			 // usu = (Usuario) request.getSession().getAttribute("usuario");
			 // usu = (Usuario) session.getAttribute("usuario");
			 // usu = (Usuario) sesion.getAttribute("usuario");
			 System.out.println(usu);
			//  if (listaPed.size() != 0 && totalPagar > 0) {
	                Pedido p = new Pedido();
	                p.setUsu(usu);
	                long miliseconds =  System.currentTimeMillis();
	                Date date = new Date(miliseconds);
	                p.setFechaPedido(date);
	                p.setMonto(totalPagar);
	                p.setEstado("En Proceso de Envio");
	                ctrlped.add(p);
	            
                LinkedList<Pedido> pedidos = ctrlped.getAll();
                request.setAttribute("listaPedidos", pedidos);
                request.getRequestDispatcher("WEB-INF/pedidos.jsp").forward(request, response);
			// }else {
            //    request.getRequestDispatcher("abmc?accion=inicio").forward(request, response);
                break;
            }
			// break; 
        	// }  
		 	
		
		
		case "ini": 
				LinkedList<Pedido> Pedido = ctrlped.getAll();
				request.setAttribute("listaPedidos", Pedido);
				request.getRequestDispatcher("WEB-INF/pedidos.jsp").forward(request, response);
				break;
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
