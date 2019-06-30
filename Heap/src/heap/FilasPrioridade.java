
package heap;

/**
 *
 * @author rebeca
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
        
}
