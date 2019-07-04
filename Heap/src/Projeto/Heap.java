package Projeto;

/**
 *
 * @author rebeca, lucas
 */

// Implementação da classe de Heap minimo
public class Heap {
    public Vertice[] vertice;
    public int tam_heap;
    public int comp;
    
    public Heap(Vertice[] v){
        vertice = new Vertice[v.length]; // aqui deu problema no método da fila de prioridade, pq uma vez q instancia o array 
                                                // com o mesmo tamanho inserido por parametro não da pra aumentar
                                                // E nesse metodo precisa aumentar o array pra adicionar um elemento
                                                // aí to instanciando o array maior (gambiarra) que o valor passado por parametro pra evitar esse problema...
                                                // ideal seria talvez usar arraylist que é (teoricamente) infinito (não tenho certeza).
                                                // verificar a possibilidade de implementar isso e avaliar as melhorias/consequências futuras.
        tam_heap = v.length;
        comp = v.length;        
    }  
    
    public void show(Heap a){
        for(int i = 0; i < a.tam_heap; i++){
            System.out.print(a.vertice[i].valor + " ");
        }
        System.out.println("");
    }
    
    public void fill(Heap a, Vertice[] v){
        for(int i = 0; i < a.comp; i++){
            a.vertice[i] = v[i];
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
        Vertice aux1 = heap.vertice[a];
        int aux2 = heap.vertice[a].id;

        heap.vertice[a].id = heap.vertice[b].id;
        heap.vertice[a] = heap.vertice[b];

        heap.vertice[b] = aux1;
        heap.vertice[b].id =  aux2;
    }
    
    
    public void Min_heapify(Heap a, int i){
        int l = a.Esq(i);
        int r = a.Dir(i);
        int menor;
        if((l < tam_heap) && (a.vertice[l].valor < a.vertice[i].valor)){
            menor = l;
        }else{
            menor = i;
        }
        if((r < tam_heap) && (a.vertice[r].valor < a.vertice[menor].valor)){
            menor = r;
        }
        if(menor != i){
            swap(a, i, menor);
            Min_heapify(a, menor);
        }
    }
    
    public void Build_MinHeap(Heap a){
        a.comp = a.tam_heap;
        
        for(int i = (a.comp/2); i >= 0; i--){
            Min_heapify(a, i);
        }
        //System.out.println("Build-Min-Heap: "+ Arrays.toString(a.vetor));
    }
    
}
