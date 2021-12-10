package servlet;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entities.Categoria;
import Entities.Producto;
import Logic.LogicCategoria;
import Logic.LogicProducto;


/**
 * Servlet implementation class abmcCategorias
 */
@WebServlet("/abmcProductos")
public class abmcProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public abmcProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    String add="WEB-INF/NewProducto.jsp";
    String list="WEB-INF/listarProductos.jsp";
    String editar="WEB-INF/EditProducto.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogicProducto ctrl = new LogicProducto();
		String acceso="";
		String action=request.getParameter("accion");
		switch(action) {
		 case "add": request.getRequestDispatcher("WEB-INF/NewProducto.jsp").forward(request, response);
		 			break;
		 case "listar": {	LinkedList<Producto> Producto = ctrl.getAll();
		 					request.setAttribute("listaProductos", Producto);
		 					request.getRequestDispatcher(list).forward(request, response);}
		 			break;
		 case "inicio":{
			 			LinkedList<Producto> Producto = ctrl.getAll();
			 			request.setAttribute("listaProductos", Producto);
			 			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		 				}
		 			break;
		 case "agregar": {Producto prod = new Producto();
		 				  Categoria cat = new Categoria();
						LogicProducto ctrlLogin = new LogicProducto();
						String idCategoria = request.getParameter("idCategoria");
						String descripcion = request.getParameter("descripcion");
						String precio = request.getParameter("precio");
						String stock = request.getParameter("stock");
						prod.setDescripcion(descripcion);
						prod.setPrecio(Float.parseFloat(precio));
						prod.setStock(Integer.parseInt(stock));
						cat.setIdCategoria(Integer.parseInt(idCategoria));
						prod.setCat(cat);
						ctrlLogin.add(prod);
						LinkedList<Producto> Producto = ctrl.getAll();
						request.setAttribute("listaProductos", Producto);
						request.getRequestDispatcher("WEB-INF/listarProductos.jsp").forward(request, response);
		 		break;}
		 case "borrar":{Producto prod = new Producto();
						LogicProducto ctrlLogin = new LogicProducto();
						String id = request.getParameter("idProducto");
						prod.setIdProducto(Integer.parseInt(id));
						ctrlLogin.delete(prod);
						LinkedList<Producto> Producto = ctrl.getAll();
						request.setAttribute("listaProductos", Producto);
						request.getRequestDispatcher("WEB-INF/listarProductos.jsp").forward(request, response);
				break;}
		case "editar":{
					request.getRequestDispatcher(editar).forward(request, response);
				break;}
		 case "actualizar":{
			 Producto prod = new Producto();
			 Categoria cat = new Categoria();
			 LogicProducto ctrlLogin = new LogicProducto();
			 String id = request.getParameter("idProducto");
			 String idCategoria = request.getParameter("idCategoria");
			 String descripcion = request.getParameter("descripcion");
			 String precio = request.getParameter("precio");
			 String stock = request.getParameter("stock");
			 prod.setIdProducto(Integer.parseInt(id));
			 prod.setDescripcion(descripcion);
			 prod.setPrecio(Float.parseFloat(precio));
			 prod.setStock(Integer.parseInt(stock));
			 cat.setIdCategoria(Integer.parseInt(idCategoria));
			 prod.setCat(cat);
			 ctrlLogin.edit(prod);
			 LinkedList<Producto> Producto = ctrl.getAll();
			 request.setAttribute("listaProductos", Producto);
			 request.getRequestDispatcher("WEB-INF/listarProductos.jsp").forward(request, response);
		 }
		 case "salir":
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}