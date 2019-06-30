package Projeto;

import java.util.Arrays;

/**
 *
 * @author rebeca, lucas
 */

// Implementação da classe de Heap minimo
public class Heap {
    public int[] vetor;
    public int tam_heap;
    public int comp;
    
    public Heap(int size){
        vetor = new int[Integer.MAX_VALUE/100]; // aqui deu problema no método da fila de prioridade, pq uma vez q instancia o array 
                                                // com o mesmo tamanho inserido por parametro não da pra aumentar
                                                // E nesse metodo precisa aumentar o array pra adicionar um elemento
                                                // aí to instanciando o array maior (gambiarra) que o valor passado por parametro pra evitar esse problema...
                                                // ideal seria talvez usar arraylist que é (teoricamente) infinito (não tenho certeza).
                                                // verificar a possibilidade de implementar isso e avaliar as melhorias/consequências futuras.
        tam_heap = size;
        comp = size;        
    }  
    
    public void show(Heap a){
        for(int i = 0; i < a.tam_heap; i++){
            System.out.print(a.vetor[i] + " ");
        }
        System.out.println("");
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
            swap(a, i, menor);
            Min_heapify(a, menor);
        }
    }
    
    public void Build_MinHeap(Heap a){
        a.tam_heap = a.comp;
        
        for(int i = a.comp; i >= 0; i--){
            Min_heapify(a, i);
        }
        //System.out.println("Build-Min-Heap: "+ Arrays.toString(a.vetor));
    }
    
}
