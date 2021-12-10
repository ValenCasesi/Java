package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import Entities.Categoria;
import Entities.Producto;

public class DataProducto {

	public LinkedList<Producto> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> prod= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idproducto,idcategoria,descripcion, precio, stock from producto");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Producto p=new Producto();
					Categoria cat=new Categoria();
					p.setIdProducto(rs.getInt("idProducto"));
					cat.setIdCategoria(rs.getInt("idCategoria"));
					p.setDescripcion(rs.getString("descripcion"));
					p.setPrecio(rs.getFloat("precio"));
					p.setStock(rs.getInt("stock"));
					// p.setImg(rs.getBlob("img"));
					p.setCat(cat);
					prod.add(p);
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
		
		
		return prod;
	}

	
	public Producto getByIdProducto(Producto prod) {
		Producto p=null;
		Categoria c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idProducto,idcategoria,descripcion, precio, stock from producto where idProducto=?"
					);
			stmt.setInt(1, prod.getIdProducto());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Producto();
				c=new Categoria();
				p.setIdProducto(rs.getInt("idProducto"));
				c.setIdCategoria((rs.getInt("idcategoria")));
				p.setCat(c);
				p.setDescripcion(rs.getString("descripcion"));
				p.setPrecio(rs.getFloat("precio"));
				p.setStock(rs.getInt("stock"));
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
	
	public void add(Producto p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into producto(idcategoria, descripcion, precio, stock) values(?, ?, ?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, p.getCat().getIdCategoria());
			stmt.setString(2, p.getDescripcion());
			stmt.setFloat(3, p.getPrecio());
			stmt.setInt(4, p.getStock());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdProducto(keyResultSet.getInt(1));
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
	
	public void delete(Producto prod) {
		PreparedStatement stmt=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM producto WHERE idproducto= ?");
			stmt.setInt(1,prod.getIdProducto());
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


	public void edit(Producto prod) {
			PreparedStatement stmt = null;
			try {
				stmt=DbConnector.getInstancia().getConn().prepareStatement("UPDATE producto set idcategoria=?, descripcion=?, precio=?, stock=?  WHERE idproducto=? ");
				stmt.setInt(1, prod.getCat().getIdCategoria());
				stmt.setString(2, prod.getDescripcion());
				stmt.setFloat(3, prod.getPrecio());
				stmt.setInt(4, prod.getStock());
				stmt.setInt(5, prod.getIdProducto());
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


	public LinkedList<Producto> getByDescripcion(Producto prod) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> prods= new LinkedList<>();
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("Select * from producto   WHERE descripcion LIKE  concat(?,'%') ");
			stmt.setInt(1, prod.getCat().getIdCategoria());
			stmt.setString(2,prod.getDescripcion());
			stmt.setFloat(3, prod.getPrecio());
			stmt.setInt(4, prod.getStock());
			rs = stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Producto p=new Producto();
					Categoria c= new Categoria();
					c.setIdCategoria(rs.getInt("idcategoria"));
					p.setIdProducto(rs.getInt("idProducto"));
					p.setDescripcion(rs.getString("descripcion"));
					p.setPrecio(rs.getFloat("precio"));
					p.setStock(rs.getInt("stock"));
					p.setCat(c);
					prods.add(p);
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
		
		
		return prods;
	}


	
}