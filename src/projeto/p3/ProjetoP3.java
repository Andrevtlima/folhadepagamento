/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.p3;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Casa
 */
public class ProjetoP3 {

    public int id =0;
    public Empregado create_emp_horistas(String name, String End,String type,double sal_hor){
        Empregado new_emp = new Empregado();
        try {
            new_emp.name = name;
            new_emp.end = End;
            new_emp.sal_hor = sal_hor;
            new_emp.type = type;
            new_emp.id = id;
            id++;
            return new_emp;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
    public Empregado create_emp_assalariado(String name, String End,String type,double sal_mes, double comissao){
        Empregado new_emp = new Empregado();
        try {
            new_emp.name = name;
            new_emp.end = End;
            new_emp.sal_mes = sal_mes;
            new_emp.comissao = comissao;
            new_emp.type = type;
            new_emp.id = id;
            id++;
            return new_emp;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
    
    public static Empregado[] remove_emp(Empregado[] empregados, int id){
        Empregado[] new_array = new Empregado[empregados.length];
        int i=0;
        for(Empregado empregado : empregados){
            if(empregado.id != id){
                new_array[i] = empregado;
            }
        }
        return new_array;
    }
    
    public static CartaoPonto lancarPonto(int id, Time hr_chegada,Time hr_saida){
        CartaoPonto new_Cartao = new CartaoPonto();
        new_Cartao.id_emp = id;
        new_Cartao.hora_chegada = hr_chegada;
        new_Cartao.hora_saida = hr_saida;
        return new_Cartao;
    }
    
    public static Venda lancarVenda(int id_emp, Date data, double valor){
        Venda new_venda = new Venda();
        new_venda.id_emp = id_emp;
        new_venda.data = data;
        new_venda.valor_venda = valor;
        return new_venda;
    }
    public static TaxaServiço lancarTaxa(int id_emp, double taxa){
        TaxaServiço newTaxa = new TaxaServiço();
        newTaxa.id_emp = id_emp;
        newTaxa.taxa = taxa;
        return newTaxa;
    }
    
    @SuppressWarnings("empty-statement")
    public static Empregado[] alterEmp(Empregado empregados[]){
        Scanner entrada = new Scanner (System.in);
        System.out.println("Digite o id do empregado que você deseja alterar");
        int id_emp = entrada.nextInt();
        Empregado empregadoAux = empregados[0];
        for(Empregado empregado : empregados){
            if(empregado.id == id_emp){
                empregadoAux = empregado;
            }
        }
        System.out.println("Digite o número da alteração que você deseja realizar no empregado:\n1---Nome\n2----Endereço\n3----Tipo\n4----Método de Pagamento\n5----Participação no sindicato\n6----Taxa sindical");
        int escolha = entrada.nextInt();;
        switch(escolha){
            case 1:
                System.out.println("Digite o novo nome:");
                String name =entrada.nextLine();
                empregadoAux.name = name;
                break;
            case 2:
                System.out.println("Digite o novo Endereço:");
                String end = entrada.nextLine();
                empregadoAux.end = end;
                break;
            case 3:
                System.out.println("Digite o novo Tipo:");
                String type = entrada.nextLine();
                empregadoAux.type = type;
                break;
            case 4:
                System.out.println("Digite o novo Metodo de pagamento:");
                String metodo = entrada.nextLine();
                empregadoAux.metodo = metodo;
                break;
            case 5:
                System.out.println("Digite 1 se o empregado pertence ao sindicato e 0 se não pertence:");
                boolean sindicato = entrada.nextBoolean();
                empregadoAux.sindicato = sindicato;
                break;
            case 6:
                System.out.println("Digite a nova taxa sindical do empregado:");
                double taxa = entrada.nextDouble();
                empregadoAux.taxa_sindicato = taxa;
                break;           
            default:
                break;
        }
        return null;
    }
    /* Horistas Eles são pagos toda sexta feira*/
    /*Assalariados Eles são pagos mensalmente*/
    /*Comissionados Quizenalmente*/
    public static  void pagamento(Date date,Empregado[] empregados, CartaoPonto[] cartoesPonto){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        boolean friday;
        GregorianCalendar calendar = new GregorianCalendar();
        
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
            friday = true;
        }
        else
            friday = false;
        
        
        /*Pagamento Horistas*/
        for(Empregado empregado : empregados){
            if(empregado.type.equals("Horistas")){
                if(friday){
                        cal.add(Calendar.DAY_OF_YEAR, -4);
                        for(CartaoPonto cartao : cartoesPonto){
                            if(cartao.id_emp == empregado.id && cartao.hora_chegada.equals(date)){
                                
                            }
                        }
                        System.out.println(cal.getTime());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Empregado[] empregados = new Empregado[50];
        
        
        
        
    }
    
}
