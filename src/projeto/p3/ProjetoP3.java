/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.p3;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Casa
 */
public class ProjetoP3 {

    
    public static Empregado create_emp_horistas(String name, String End,String type,double sal_hor,int id){
        Empregado new_emp = new Empregado();
        try {
            new_emp.name = name;
            new_emp.end = End;
            new_emp.sal_hor = sal_hor;
            new_emp.type = type;
            new_emp.id = id;
            return new_emp;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
    public static Empregado create_emp_assalariado(String name, String End,String type,double sal_mes, double comissao, int id){
        Empregado new_emp = new Empregado();
        try {
            new_emp.name = name;
            new_emp.end = End;
            new_emp.sal_mes = sal_mes;
            new_emp.comissao = comissao;
            new_emp.type = type;
            new_emp.id = id;
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
    
    public static int menu(Scanner entrada, Date date){
            
            System.out.println("------------ MENU ------------ ");
            System.out.println("1 - Adicionar empregado");
            System.out.println("2 - Remover empregado");
            System.out.println("3 - Lançar um cartão de ponto");
            System.out.println("4 - Venda");
            System.out.println("5 - Lançar uma taxa de serviço");
            System.out.println("6 - Alterar detalhes de um empregado");
            System.out.println("7 - Rodar a folha de pagamento para hoje");
            System.out.println("8 - Agendar pagamento");
            System.out.println("9 - Undo/Redo");
            System.out.println("10 - Mostrar empregado");
            System.out.println("11 - Criar nova agenda de pagamento");
            System.out.println("0 - Sair");
            
            return entrada.nextInt();
    }
    
    public static void main(String[] args) {
        int id =0;
        Scanner entrada = new Scanner (System.in);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        date = new Date();
//        Calendar c = Calendar.getInstance(); 
//        c.setTime(date); 
//        c.add(Calendar.DATE, 1);
//        date = c.getTime();
        
        @SuppressWarnings("MismatchedReadAndWriteOfArray")
        Empregado[] empregados = new Empregado[50];
        
        int escolha;
        System.out.println("Hoje é dia "+ dateFormat.format(date));
        escolha=menu(entrada,date);
        while (escolha != 0) {
            switch(escolha){
                case 1:
                    entrada.nextLine();
                    System.out.println("Digite o nome do funcionario:");
                    String name = entrada.nextLine();
                    System.out.println("Digite o end do funcionario:");
                    String end = entrada.nextLine();
                    System.out.println("Digite o type do funcionario:");
                    String type = entrada.nextLine();
                    if(type.equals("Assalariado")){
                        System.out.println("Digite o salario do funcionario:");
                        Double sal_mes = entrada.nextDouble();
                        System.out.println("Digite o comissao do funcionario:");
                        Double comissao = entrada.nextDouble();
                        empregados[id] = create_emp_assalariado(name, end, type, sal_mes, comissao, id+1);
                        System.out.println(empregados[0].id);
                        id++;
                    }
                    else{
                        System.out.println("Digite o valor da hora do funcionario:");
                        Double sal_hor = entrada.nextDouble();
                        empregados[id] = create_emp_horistas(name, end, type, sal_hor, id);
                        System.out.println(empregados[0].id);
                        id++;
                    }
                       
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                default:
                    break;
            }
            
            System.out.println("Hoje é dia "+ dateFormat.format(date));
            escolha=menu(entrada,date);
        
                    
        }
                
       
        
        
        
        
        
        
        
       
        
        
        
        
    }
    
}
