package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Categoria;
import Logic.LogicCategoria;


/**
 * Servlet implementation class abmcCategorias
 */
@WebServlet("/abmcCategorias")
public class abmcCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public abmcCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    String add="WEB-INF/NewCategoria.jsp";
    String list="WEB-INF/listarCategorias.jsp";
    String editar="WEB-INF/EditCategoria.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogicCategoria ctrl = new LogicCategoria();
		String acceso="";
		String action=request.getParameter("accion");
		switch(action) {
		 case "add": request.getRequestDispatcher("WEB-INF/NewCategoria.jsp").forward(request, response);
		 			break;
		 case "listar": {	LinkedList<Categoria> categorias = ctrl.getAll();
		 					request.setAttribute("listaCategorias", categorias);
		 					request.getRequestDispatcher(list).forward(request, response);}
		 			break;
		 case "agregar": {Categoria cat = new Categoria();
						LogicCategoria ctrlLogin = new LogicCategoria();
						String descripcion = request.getParameter("descripcion");
						cat.setDescripcion(descripcion);
						ctrlLogin.add(cat);
						LinkedList<Categoria> categorias = ctrl.getAll();
						request.setAttribute("listaCategorias", categorias);
						request.getRequestDispatcher("WEB-INF/listarCategorias.jsp").forward(request, response);
		 		break;}
		 case "borrar":{Categoria cat = new Categoria();
						LogicCategoria ctrlLogin = new LogicCategoria();
						String id = request.getParameter("idCategoria");
						cat.setIdCategoria(Integer.parseInt(id));
						ctrlLogin.delete(cat);
						LinkedList<Categoria> categorias = ctrl.getAll();
						request.setAttribute("listaCategorias", categorias);
						request.getRequestDispatcher("WEB-INF/listarCategorias.jsp").forward(request, response);
				break;}
		case "editar":{
						request.getRequestDispatcher(editar).forward(request, response);
				break;}
		 case "actualizar":{
			 Categoria cat = new Categoria();
			 LogicCategoria ctrlLogin = new LogicCategoria();
			 String id = request.getParameter("idCategoria");
			 String descripcion = request.getParameter("descripcion");
			 cat.setIdCategoria(Integer.parseInt(id));
			 cat.setDescripcion(descripcion);
			 ctrlLogin.edit(cat);
			 LinkedList<Categoria> categorias = ctrl.getAll();
			 request.setAttribute("listaCategorias", categorias);
			 request.getRequestDispatcher("WEB-INF/listarCategorias.jsp").forward(request, response);
		 }
		 case "home":{
			 LinkedList<Categoria> categorias = ctrl.getAll();
			 request.setAttribute("listaCategorias", categorias);
			 request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
			 
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
