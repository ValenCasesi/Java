package Logic;

import java.util.LinkedList;
import java.util.List;

import Data.DataPedido;
import Entities.DetalleCompra;
import Entities.Pedido;

public class LogicPedido {
private DataPedido dp;
	
	public LinkedList<Pedido> getAll(){
		dp = new DataPedido();
		return dp.getAll();
	}
	
	public void add(Pedido ped) {
		dp=new DataPedido();
		dp.add(ped);
	}
	
	public void delete(Pedido ped) {
		dp=new DataPedido();
		dp.delete(ped);
	}
	
	public Pedido getMax() {
		dp= new DataPedido();
		return dp.getMax();
	}
	
	public void adddc(DetalleCompra dc) {
		dp = new DataPedido();
		dp.adddc(dc);
	}

	public List<DetalleCompra> getOne(int idpedido) {
		dp = new DataPedido();
		return dp.getOne(idpedido);
	}
}
