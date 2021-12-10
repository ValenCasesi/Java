package Logic;

import java.util.LinkedList;
import Data.DataProducto;
import Entities.Producto;

public class LogicProducto {
	
	private DataProducto dp;
	
	public LinkedList<Producto> getAll(){
		dp = new DataProducto();
		return dp.getAll();
	}
	
	public Producto getByIdProducto(Producto prod) {
		dp=new DataProducto();
		return dp.getByIdProducto(prod);
	}
	
	public void add(Producto prod) {
		dp=new DataProducto();
		dp.add(prod);
	}
	
	public void delete(Producto prod) {
		dp=new DataProducto();
		dp.delete(prod);
	}

	public void edit(Producto prod) {
		dp = new DataProducto();
		dp.edit(prod);
		
	}
	public LinkedList<Producto> getByDescripcion(Producto prod){
		dp=new DataProducto();
		return dp.getByDescripcion(prod);
	}
}
