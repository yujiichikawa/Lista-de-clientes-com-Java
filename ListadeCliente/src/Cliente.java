
public class Cliente implements Comparable<Cliente>{
    private String customer;
    private int cod;
    
    public Cliente(String customer, int cod) {
        this.customer = customer;
        this.cod = cod;
    }
    public String toString(){
        return (this.getName());
    }
    public String getName() {
        return customer;
    } 
    public void setName(String customer) {
        this.customer = customer;
    }
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    @Override
    public int compareTo(Cliente cliente) {
        return this.getName().compareTo(cliente.getName());
    }
    
}
