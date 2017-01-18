package p3;

import java.sql.Date;

public class Main {
	public int id;

	public static void main(String[] args) {
		
		
		
		
	}

	public static Trabalhador create_emp(String[] name, String[] end, short type, double sal, double comissao){
		Trabalhador trabalhador = new Trabalhador();
		trabalhador.name = name;
		trabalhador.end = end;
		trabalhador.type = type;
		switch (type) {
		case 1:
			trabalhador.salario_horario = sal;
			break;
		case 2:
			trabalhador.salario_mensal = sal;
			break;	
		case 3:
			trabalhador.comissao = sal;
			break;	
		default:
			break;
		}
		return null;
		
	}
}
