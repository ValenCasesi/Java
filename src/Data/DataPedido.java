package Data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import Entities.Categoria;
import Entities.DetalleCompra;
import Entities.Pedido;
import Entities.Producto;
import Entities.Usuario;

public class DataPedido {

	public LinkedList<Pedido> getAll() {
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Pedido> ped= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idpedido,estado,fecha,dni,monto from pedido");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Pedido p=new Pedido();
					Usuario u = new Usuario();
					p.setIdPedido(rs.getInt("idpedido"));
					p.setEstado(rs.getString("estado"));
					p.setFechaPedido(rs.getDate("fecha"));
					u.setDni(rs.getString("dni"));
					p.setUsu(u);
					p.setMonto(rs.getDouble("monto"));
					ped.add(p);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		return ped;
	}
	
	public void add(Pedido p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into Pedido(idpedido,estado,fecha,dni,monto) values(?, ?, ?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, p.getIdPedido());
			stmt.setString(2, p.getEstado());
			stmt.setDate(3, (Date) p.getFechaPedido());
			stmt.setString(4, p.getUsu().getDni());
			stmt.setDouble(5,p.getMonto());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdPedido(keyResultSet.getInt(1));
            }
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }
	
	public void delete(Pedido ped) {
		PreparedStatement stmt=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM pedido WHERE idpedido= ?");
			stmt.setInt(1,ped.getIdPedido());
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	public Pedido getMax() {
		Pedido p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select max(idpedido) from pedido"
					);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Pedido();
				p.setIdPedido(rs.getInt("idpedido"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}
	/*
	 int idc = 0;
        String sql = "select max(idCompras) from compras";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idc = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return idc;*/

	public void adddc(DetalleCompra dc) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into detalle_compra(idpedido,idproducto,cantidad,precio) values(?, ?, ?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, dc.getIdPedido());
			stmt.setInt(2, dc.getIdProducto());
			stmt.setInt(3, dc.getCant());
			stmt.setFloat(4, dc.getPrecio());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                dc.setIdDetalle(keyResultSet.getInt(1));
            }
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		
		/* String sql = "insert into Detalle_Compras(idProducto,idCompras, Cantidad, PrecioCompra)values(?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dc.getIdproducto());
            ps.setInt(2, dc.getIdcompra());
            ps.setInt(3, dc.getCantidad());
            ps.setDouble(4, dc.getPrecioCompra());
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
        }
        
	}*/
	
	}

	public List<DetalleCompra> getOne(int idpedido) {
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<DetalleCompra> ped= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select DC.idDetalle, P.Nombre, DC.idpedido, DC.Cantidad, DC.Precio "
					+ "FROM detalle_compras DC inner join producto P on P.idProducto = DC.idProducto where idCompras= " + idpedido);
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					DetalleCompra dcom = new DetalleCompra();
	                dcom.setIdDetalle(rs.getInt(1));
	                dcom.setProducto(new Producto());
	                dcom.getProducto().setDescripcion(rs.getString(2));
	                dcom.setIdPedido(rs.getInt(3));
	                dcom.setCant(rs.getInt(4));
	                dcom.setPrecio(rs.getFloat(5));
					ped.add(dcom);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		return ped;
	}
}
