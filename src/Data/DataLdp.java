package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import Entities.Producto;
import Logic.LogicProducto;
import Entities.LineaDePedido;

public class DataLdp {
	public LinkedList<LineaDePedido> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<LineaDePedido> ldp= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select nroldp,idProducto,cantidad,subTotal from lineadepedido");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					LineaDePedido lp=new LineaDePedido();
					Producto prod=new Producto();
					LogicProducto ctrlProd = new LogicProducto();
					lp.setNroldp(rs.getInt("nroldp"));
					prod.setIdProducto(rs.getInt("idProducto"));
					prod = ctrlProd.getByIdProducto(prod);
					lp.setCant(rs.getInt("cantidad"));
					lp.setSubTot(rs.getFloat("subTotal"));
					lp.setProd(prod);
					ldp.add(lp);
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
		
		return ldp;
	}

	public void delete(LineaDePedido ldp) {
		PreparedStatement stmt=null;
		try 
		{
			stmt=DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM lineadepedido WHERE nroldp= ?");
			stmt.setInt(1,ldp.getNroldp());
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

	public void add(LineaDePedido ldp) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into lineadepedido(idProducto, cantidad, subtotal) values(?, ?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, ldp.getProd().getIdProducto());
			stmt.setInt(2, ldp.getCant());
			stmt.setDouble(3, ldp.getSubTot());
			// stmt.setInt(5,ldp.getIdped);
			stmt.executeUpdate();
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
	}
}
