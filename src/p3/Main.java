package p3;

import java.sql.Date;

public class Main {

	public static void main(String[] args) {
		
		Assalariados trabalhador = new Assalariados();
		trabalhador.comissionado = true;
		trabalhador.venda.data = Date.valueOf("2001-02-01");
		trabalhador.venda.valor = 662.5;
		
		
	}

}
