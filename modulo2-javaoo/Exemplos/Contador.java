
/**
 * Write a description of class Contador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contador {
    
    private int valor;
    
        
    public Contador(){
        valor = 0;
    }
    
    /**
     * Obtem o valor do contador.
     * @return Valor do contador
     */
    public int getValor(){
        return valor; // retorna valor
    }
    
    /*public void setValor(int valorNovo){
        valor = valorNovo;
    }*/
    
    /**
     * Incrementa o valor do contador
     */
    public void incremente(){
        //valor = valor + 1;
        valor++;
    }
    
    /**
     * Zera o valor do contador
     */
    public void zerar(){
        valor = 0;
    }
    
}
