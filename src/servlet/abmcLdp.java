package servlet;



import Entities.DetalleCompra;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Logic.LogicLdp;
import Logic.LogicPedido;
import Logic.LogicProducto;
import Data.DataProducto;
import Entities.LineaDePedido;
import Entities.Pedido;
import Entities.Producto;
import Entities.Usuario;

/**
 * Servlet implementation class abmcLdp
 */
@WebServlet("/abmcLdp")
public class abmcLdp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public abmcLdp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    LogicProducto ctrl = new LogicProducto();
    LogicLdp ctrlldp = new LogicLdp();
    Producto Prod = new Producto();
    // LinkedList<Producto> Productos = new LinkedList<>();
    
    ArrayList<LineaDePedido> listaLdp = new ArrayList<>();
    LinkedList<LineaDePedido> listaLdp1 = new LinkedList<>();
    int item=0;
    double subtotal=0.0;
    double totalPagar=0.0;
    int cant;
    int k = 0;
    int idpedido;
    LogicPedido ctrlped = new LogicPedido();
    Usuario usu = new Usuario();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		switch (accion) {
		case "AgregarCarrito" :{
									int pos = -1 ;
									cant = 1;
									int idProd = Integer.parseInt(request.getParameter("id"));
									 LogicProducto ctrlprod = new LogicProducto();
									 if (listaLdp.size() > 0) {
									for (int i=0 ; i<listaLdp.size(); i++) {
										if(listaLdp.get(i).getProd().getIdProducto() == idProd) {
											pos = i;
										}
									}	
									if(pos != -1) {
										cant = listaLdp.get(pos).getCant() + cant;
										double subtotal = listaLdp.get(pos).getProd().getPrecio() * cant;
										listaLdp.get(pos).setCant(cant);
										listaLdp.get(pos).setSubTot(subtotal);
										request.setAttribute("carrito", listaLdp);
										request.getRequestDispatcher("abmc?accion=inicio").forward(request, response);
									}else {
										Prod.setIdProducto(idProd);
										Prod = ctrl.getByIdProducto(Prod);
										LineaDePedido ldp = new LineaDePedido();
										ldp.setProd(Prod);
										ldp.setCant(cant);
										ldp.setSubTot(cant*Prod.getPrecio());
										listaLdp.add(ldp);
										// ctrlldp.add(ldp);
										request.setAttribute("carrito", listaLdp);
										request.getRequestDispatcher("abmc?accion=inicio").forward(request, response);
									}
									break;
									} else {
									// int idProd = Integer.parseInt(request.getParameter("id"));	
									Prod.setIdProducto(idProd);
									Prod = ctrl.getByIdProducto(Prod);
									item=item+1;
									LineaDePedido ldp = new LineaDePedido();
									ldp.setNroldp(item);
									ldp.setProd(Prod);
									ldp.setCant(cant);
									ldp.setSubTot(cant*Prod.getPrecio());
									listaLdp.add(ldp);
									ctrlldp.add(ldp);
									// request.setAttribute("contador", listaLdp.size());
									request.setAttribute("carrito", listaLdp);
									request.getRequestDispatcher("abmc?accion=inicio").forward(request, response);}
								break;
								}
		/*case "aggc":{
			cant = 1;
			int pos=-1;
			int idProd = Integer.parseInt(request.getParameter("id"));
		    Prod.setIdProducto(idProd);
		    Prod = ctrl.getByIdProducto(Prod);
		    for(LineaDePedido listaLdp2: listaLdp1) {
		    Producto prod2 =listaLdp2.getProd();
		    		if(prod2.getIdProducto() == idProd)
		    			{ pos =listaLdp1.indexOf(listaLdp2);
		    			break;
		    			}
		    		}
		    if(listaLdp1.size() > 0 && pos != -1) {
		    	cant = listaLdp.get(pos).getCant() + cant;
				double subtotal = listaLdp.get(pos).getProd().getPrecio() * cant;
				listaLdp.get(pos).setCant(cant);
				listaLdp.get(pos).setSubTot(subtotal);
				request.setAttribute("carrito", listaLdp);
				request.getRequestDispatcher("abmc?accion=inicio").forward(request, response);
		    }else {
		    	Prod.setIdProducto(idProd);
				Prod = ctrl.getByIdProducto(Prod);
				item=item+1;
				LineaDePedido ldp = new LineaDePedido();
				ldp.setNroldp(item);
				ldp.setProd(Prod);
				ldp.setCant(cant);
				ldp.setSubTot(cant*Prod.getPrecio());
				listaLdp.add(ldp);
				// ctrlldp.add(ldp);
				// request.setAttribute("contador", listaLdp.size());
				request.setAttribute("carrito", listaLdp);
				request.getRequestDispatcher("abmc?accion=inicio").forward(request, response);
		    }
		}*/
				/*case "updateCantidad":{
			            int idProd = Integer.parseInt(request.getParameter("idprod"));
			            int cant = Integer.parseInt(request.getParameter("cantidad"));
			            for (int j = 0; j < listaLdp.size(); j++) {
			                if (listaLdp.get(j).getProd().getIdProducto() == idProd) {
			                	listaLdp.get(j).setCant(cant);
			                	listaLdp.get(j).setSubTot(listaLdp.get(j).getProd().getPrecio() * cant);
			                }
			            		}
						}
			            break;*/
		case "generarCompra":{
			    usu = (Usuario) request.getSession().getAttribute("usuario");
			  // usu = (Usuario) session.getAttribute("usuario");
			 // usu = (Usuario) sesion.getAttribute("usuario");
			 System.out.println(usu);
			 if (listaLdp.size() != 0 && totalPagar > 0) {
	                Pedido p = new Pedido();
	                p.setUsu(usu);
	                long miliseconds =  System.currentTimeMillis();
	                Date date = new Date(miliseconds);
	                p.setFechaPedido(date);
	                p.setMonto(totalPagar);
	                p.setEstado("En Proceso de Envio");
	                Pedido p1 = new Pedido(); 
	                p1 = ctrlped.getMax();
                    for (int i = 0; i < listaLdp.size(); i++) {
                        DetalleCompra dc = new DetalleCompra();
                        dc.setIdPedido(p1.getIdPedido());
                        dc.setIdProducto(listaLdp.get(i).getProd().getIdProducto());
                        dc.setCant(listaLdp.get(i).getCant());
                        dc.setPrecio(listaLdp.get(i).getProd().getPrecio());
                        ctrlped.adddc(dc);
                    }
	                ctrlped.add(p);
	            
               LinkedList<Pedido> pedidos = ctrlped.getAll();
               request.setAttribute("listaPedidos", pedidos);
               request.getRequestDispatcher("WEB-INF/pedidos.jsp").forward(request, response);
			 }else {
               request.getRequestDispatcher("abmc?accion=inicio").forward(request, response);
               break;
           }
			 break;
		}
		case "misPedidos":{
			LinkedList<Pedido> pedidos = ctrlped.getAll();
            request.setAttribute("listaPedidos", pedidos);
            request.getRequestDispatcher("WEB-INF/pedidos.jsp").forward(request, response);
		}
		case "verDetalle":
            totalPagar = 0.0;
            int idpedido = Integer.parseInt(request.getParameter("idpedido"));
            List<DetalleCompra> detalle = ctrlped.getOne(idpedido);
            request.setAttribute("myDetalle", detalle);
            for (int i = 0; i < detalle.size(); i++) {
                totalPagar = totalPagar + (detalle.get(i).getPrecio() * detalle.get(i).getCant());
            }
            request.setAttribute("montoPagar", totalPagar);
            request.getRequestDispatcher("WEB-INF/DetalleCompra.jsp").forward(request, response);
            break;
		case "Carrito" :{
						totalPagar = 0.0;
						request.setAttribute("carrito", listaLdp);
						for(int i=0 ; i < listaLdp.size();i++) {
							totalPagar = totalPagar + listaLdp.get(i).getSubTot();
						}
						request.setAttribute("totalPagar", totalPagar);
						request.getRequestDispatcher("WEB-INF/Carrito.jsp").forward(request, response);
						break;
						}
		case "borrar":{ 
						LineaDePedido ldp = new LineaDePedido();
						LogicLdp ctrlLdp = new LogicLdp();
						String id = request.getParameter("nro");
						ldp.setNroldp(Integer.parseInt(id));
						ctrlLdp.delete(ldp);
						LinkedList<LineaDePedido> listaldp = ctrlLdp.getAll();
						request.setAttribute("carrito", listaldp);
						request.getRequestDispatcher("WEB-INF/Carrito.jsp").forward(request, response);
						break;}
		case "delete":{
			int idProducto = Integer.parseInt(request.getParameter("id"));
            for (int j = 0; j < listaLdp.size(); j++) {
                if (listaLdp.get(j).getProd().getIdProducto() == idProducto) {
                	totalPagar = totalPagar - listaLdp.get(j).getSubTot();
                	listaLdp.remove(j);
                }
        }
            request.setAttribute("totalPagar", totalPagar);
            request.setAttribute("carrito", listaLdp);
			request.getRequestDispatcher("WEB-INF/Carrito.jsp").forward(request, response);
		}
		case "listar":{
						LogicLdp ctrlLdp = new LogicLdp();
						LinkedList<LineaDePedido> listaldp = ctrlLdp.getAll();
						request.setAttribute("carrito", listaldp);
						request.getRequestDispatcher("WEB-INF/Carrito.jsp").forward(request, response);
			
						break;}
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
