import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    static Scanner scr = new Scanner(System.in);
	static ArrayList<Cliente> customer = new ArrayList<>();
	static int option;
	static int code = 0;
    public static void main(String[] args) throws Exception {
        do {
			System.out.println("[1]- ADICIONAR CLIENT");
			System.out.println("[2]- LISTAR CLIENTE");
			System.out.println("[3]- REMOVER CLIENTE");
			System.out.println("[4]- PESQUISAR CLIENTE");
			System.out.println("[5]- CODIGOS DOS CLIENTES");
			System.out.println("[0]- FECHAR SISTEMA");
			try {
				System.out.println("OPÇÃO:");
				option = scr.nextInt();
				scr.nextLine();
			}catch(Exception e) {
				System.out.println("OPÇÃO NÃO NUMÉRICA");
				continue;
			}
			switch(option) {
			case 1:
				addClient();
				break;
			case 2:
				listClient();
				break;
			case 3:
				removeClient();
				break;
			case 4:
                searchClient();
				break;
			case 5:
				listClientWithCode();
				break;
			case 0:
				System.out.println("FECHANDO O SISTEMA...");
				break;
			default:
				System.out.println("OPÇÃO NÃO ENCONTRADA");
				continue;
			}
		}while(option!=0);
        
    }
    public static void addClient() {
        do{
            boolean cadastrado = false;
            System.out.println("REGISTRAR CLIENTE");
		    System.out.println("NOME: ");
		    String name = scr.nextLine();
            for(Cliente search: customer){
                if(name.equals(search)){
                    System.out.println("CLIENTE JÁ CADASTRADO");
                    cadastrado = true;
                }
            }     
            if(cadastrado == true){
                
            }else{
               code++;
		        Cliente client = new Cliente(name, code);
		        customer.add(client);
		        Collections.sort(customer);
		        System.out.println("REGISTRADO COM SUCESSO"); 
            }
		    
            break;  
        }while(true);
		
	}
	public static void listClient() {
		do {
			if(customer.size() == 0) {
				System.out.println("LISTA VAZIA");
				break;
			}
			System.out.println("------------------");
			System.out.println("LISTA DE CLIENTE");
			System.out.println("------------------");
			int cont=0;
			for(Cliente search: customer) {
				cont++;
				System.out.println("["+cont+"]- "+search.toString());
			}
			System.out.println("---------------------------\n");
			break;
		}while(true);
		
	}
	public static void removeClient() {
		do{
			if(customer.size() == 0){
				System.out.println("NENHUM CLIENTE ENCONTRADO");
				break;
			}
			boolean remove =false;
			System.out.println("REMOVER CLIENTE");
			System.out.println("CÓDIGO: ");
			int code = scr.nextInt();
					
			for(Cliente search: customer) {
				if(search.getCod() == code) {
					customer.remove(search);
					System.out.println("REMOVIDO COM SUCESSO");
					remove = true;
                    break;
				}
			}
			if(remove == false) {
				System.out.println("CÓDIGO NÃO ENCONTRADO");
			}
			break;
		}while(true);
		
		
	}
	public static void searchClient() {
		do{
			if(customer.size() == 0){
				System.out.println("NENHUM CLIENTE ENCONTRADO");
				break;
			}
			boolean found = false;
			System.out.println("PESQUISAR CLIENTE");
			System.out.println("NOME: ");
			String name = scr.nextLine();
			for(Cliente search: customer) {
				if(search.getName().equals(name)) {
					System.out.println("ENCONTRADO");
					System.out.println(search.toString());
					found = true;
				}
			}
			if(found == false) {
				System.out.println("NÃO ENCONTRADO");
			}
			break;
		}while(true);
		
	}
	
	public static void listClientWithCode() {
		do {
			if(customer.size() == 0) {
				System.out.println("LISTA VAZIA");
				break;
			}
			for(Cliente search: customer) {
				System.out.println("NOME: " + search.getName()+"-" + search.getCod());
				
			}
			break;
		}while(true);	

		
	}
}
