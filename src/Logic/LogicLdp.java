package Logic;

import Data.DataLdp;
import Data.DataProducto;
import Entities.LineaDePedido;

import java.util.LinkedList;

public class LogicLdp {
	
	private DataLdp dldp;
	
	public LinkedList<LineaDePedido> getAll(){
		dldp = new DataLdp();
		return dldp.getAll();
	}

	public void delete(LineaDePedido ldp) {
		dldp=new DataLdp();
		dldp.delete(ldp);
	}

	public void add(LineaDePedido ldp) {
		dldp=new DataLdp();
		dldp.add(ldp);
		
	}
}
