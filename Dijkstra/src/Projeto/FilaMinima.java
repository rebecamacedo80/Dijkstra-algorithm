package Projeto;

/**
 *
 * @author rebeca, lucas
 */
public class FilaMinima extends Heap{
    
    public FilaMinima(Vertice[] v) {
        super(v);    
    }
    
    public int heap_minimum(FilaMinima fila){
        return fila.vertice[0].valor;
    }
    
    public Vertice heap_extractMin(){
        if(this.tam_heap < 0){
            System.out.println("error");
        }
        
        Vertice menor_vertice = this.vertice[0];    
        this.vertice[0] = this.vertice[this.tam_heap-1];
        this.vertice[0].id = 0;        
        this.tam_heap -= 1;        
        this.Min_heapify(0);
        
        return menor_vertice;
    }
    
    public void heap_decreaseKey(int i, int chave){       
        if(chave > this.vertice[i].valor){
            //Nada feito. Chave inserida é maior que a chave atual
        }else{
            this.vertice[i].valor = chave;
            
            while((i > 0) && (this.vertice[Pai(i)].valor > this.vertice[i].valor)){
                swap(i, Pai(i));
                i = Pai(i);
            }
        }
    }
    
    public void min_heapInsert(int chave){
        this.tam_heap += 1;
        this.vertice[this.tam_heap - 1].valor = Integer.MAX_VALUE;
        this.heap_decreaseKey((this.tam_heap - 1), chave);
        
    }
    
}
