package Projeto;

/**
 *
 * @author rebeca, lucas
 */

public class Heap {
    public Vertice[] vertice;
    public int tam_heap;
    public int comp;
    
    public Heap(Vertice[] v){
        vertice = new Vertice[v.length];
        tam_heap = v.length;
        comp = v.length;        
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
    
    public void show(){
        System.out.println("Show heap:");
        for(int i = 0; i < this.tam_heap; i++){            
            System.out.print(this.vertice[i].valor + " ");
        }
        System.out.println("\n");
    }
    
    public void fill(Vertice[] v){
        for(int i = 0; i < this.comp; i++){
            this.vertice[i] = v[i];            
        }
    }
    
    public void swap(int a, int b){
        Vertice aux = this.vertice[a];
        int ida = vertice[a].id;
        int idb = vertice[b].id;
        
        vertice[a] = vertice[b];
        vertice[a].id = ida;
        
        vertice[b] =  aux;
        vertice[b].id = idb;      
        
    }
    
    public void Min_heapify(int i){
        int l = this.Esq(i);
        int r = this.Dir(i);
        int menor;
        if((l < tam_heap) && (this.vertice[l].valor < this.vertice[i].valor)){
            menor = l;
        }else{
            menor = i;
        }
        if((r < tam_heap) && (this.vertice[r].valor < this.vertice[menor].valor)){
            menor = r;
        }
        if(menor != i){
            swap(i, menor);
            Min_heapify(menor);
        }
    }
    
    public void Build_MinHeap(){
        this.comp = this.tam_heap;
        
        for(int i = (this.comp/2); i >= 0; i--){
            Min_heapify(i);
        }
        
    }
    
}
