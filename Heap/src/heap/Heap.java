package heap;

/**
 *
 * @author rebeca, lucas
 */
import java.util.Arrays;

public class Heap {
    public int[] vetor;
    public int tam_heap;
    public int comp;
    
    
    public Heap(int size){
        vetor = new int[size];
        tam_heap = size;
        comp = size;        
    }    
    public void fill(Heap a, int[] v){
        for(int i = 0; i < a.comp; i++){
            a.vetor[i] = v[i];  
            
        }
    }
    
    public int Pai(int i){
        return (i -1)/2;
    }
    
    public int Dir(int i){
        return (2*i)+2;
    }
    
    public int Esq(int i){
        return (2*i)+1;
    }
    
    public void swap(Heap heap, int a, int b){
        int aux = heap.vetor[a];
        heap.vetor[a] = heap.vetor[b];
        heap.vetor[b] = aux;
    }
    
    public void Max_heapify(Heap a, int i){        
        int l = a.Esq(i);
        int r = a.Dir(i);
        int maior;
                       
        if((l < tam_heap) && (a.vetor[l] > a.vetor[i])){
            maior = l;
        }else{
            maior = i;
        }
        if((r < tam_heap) && (a.vetor[r] > a.vetor[maior])){
            maior = r;
        }
        
        if(maior != i){
            /*
            int troca;                        
            troca = a.vetor[i];
            a.vetor[i] = a.vetor[maior];
            a.vetor[maior] = troca;
            */
            
            swap(a, i, maior);
            Max_heapify(a, maior);
        }
        
    }
    
    public void Min_heapify(Heap a, int i){
        int l = a.Esq(i);
        int r = a.Dir(i);
        int menor;
        if((l < tam_heap) && (a.vetor[l] < a.vetor[i])){
            menor = l;
        }else{
            menor = i;
        }
        if((r < tam_heap) && (a.vetor[r] < a.vetor[menor])){
            menor = r;
        }
        if(menor != i){
            /*
            int troca;
            troca = a.vetor[i];
            a.vetor[i] = a.vetor[menor];
            a.vetor[menor] = troca;
            */
            swap(a, i, menor);
            Min_heapify(a, menor);
        }
    }
     
    public void Build_MaxHeap(Heap a){
        a.tam_heap = a.comp;
                
        for(int i = a.comp; i >= 0; i--){
            Max_heapify(a, i);
        }
        System.out.println("\nBuil-Max-Heap: "+ Arrays.toString(a.vetor));
    }
    
    public void Build_MinHeap(Heap a){
        a.tam_heap = a.comp;
        
        for(int i = a.comp; i >= 0; i--){
            Min_heapify(a, i);
        }
        System.out.println("Buil-Min-Heap: "+ Arrays.toString(a.vetor));
    }
    
    public void Heapsort(Heap a){
        a.Build_MaxHeap(a);
        
        for(int i = (a.comp - 1); i >= 0; i--){
            /*
            int troca;
            troca = a.vetor[i];
            a.vetor[i] = a.vetor[0];
            a.vetor[0] = troca;
            */
            swap(a, i, 0);
            a.tam_heap -= 1;
            a.Max_heapify(a, 0);
        }
        System.out.println("Heapsort concluído: " + Arrays.toString(a.vetor));
    }    
}
