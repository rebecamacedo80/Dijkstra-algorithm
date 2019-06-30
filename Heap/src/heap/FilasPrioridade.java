
package heap;

/**
 * 
 * @author rebeca, lucas
 */
public class FilasPrioridade extends Heap{
    
    public FilasPrioridade(int size) {
        super(size);
    }
        
    public int Heap_maximum(Heap a){
        a.Build_MaxHeap(a);
        return a.vetor[0];        
    }
    
    public int Heap_extractMax(Heap a){
        a.Build_MaxHeap(a);
        if(a.tam_heap < 0){
            System.out.println("Heap underflow");
            return -1;
        }
        int max = a.vetor[0];
        a.vetor[0] = a.vetor[a.tam_heap-1];
        --a.tam_heap;
        Max_heapify(a, 0);
        System.out.println("\nMaximo: " + max);
        return max;
    }
    
    public void Heap_increaseKey(Heap a, int i, int chave){
        if(chave < a.vetor[i]){
            System.out.println("Chave menor.");
        }
        a.vetor[i] = chave;
        while((i > 0) && ((a.vetor[Pai(i)]) < a.vetor[i])){
            int troca;
            
            troca = a.vetor[i];
            a.vetor[i] = a.vetor[Pai(i)];
            a.vetor[Pai(i)] = troca;
            
            i = a.Pai(i);
        }
    }
    
    public void Max_heapInsert(Heap a, int chave){
        ++a.tam_heap;
        a.vetor[tam_heap] = -1;
        Heap_increaseKey(a, tam_heap, chave);
    }
            
}
