
package heap;

/**
 *
 * @author rebeca
 */
public class Main {
    public static void main(String[] args) {
        Heap h = new Heap(6);
        FilasPrioridade fp = new FilasPrioridade(6);
        
        int[] v = {8,9,7,16,10,14};         
        h.fill(h, v);
       
        for(int i = 0; i < h.tam_heap; i++){            
            System.out.print(h.vetor[i]+" ");
                  
        }
        
        //h.Max_heapify(h, 1);
        //h.Build_MaxHeap(h);
        //h.Min_heapify(h, 4);
        //h.Build_MinHeap(h);
        //h.Heapsort(h);
        fp.Heap_extractMax(h);
        //fp.Heap_maximum(h);
        
        System.out.println(); 
        
        for(int i = 0; i < h.tam_heap; i++){
            
            System.out.print(h.vetor[i]+" ");
                        
        }
       
    }
    
}
