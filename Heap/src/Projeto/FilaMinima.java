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
    
    public Vertice heap_extractMin(FilaMinima fila){
        if(fila.tam_heap < 0){
            System.out.println("error");
        }
        // avaliar se esse bloco de codigo abaixo deve estar dentro de um else
        Vertice menor_vertice = fila.vertice[0];
        fila.vertice[0] = fila.vertice[fila.tam_heap-1];
        fila.vertice[0].id = 0;
        fila.tam_heap -= 1;
        fila.Min_heapify(fila, 0);
        return menor_vertice;
    }
    
    public void heap_increaseKey(FilaMinima fila, int i, int chave){
        // a chave é basicamente o conteudo do elemento do array
        if(chave > fila.vertice[i].valor){
            System.out.println("Erro: a chave inserida é maior que a chave atual");
        }else{
            // avaliar se este bloco dentro do else realmente necessita estar nesta condição
            fila.vertice[i].valor = chave;
            
            while((i > 0) && (fila.vertice[Pai(i)].valor > fila.vertice[i].valor)){
                swap(fila, i, Pai(i));
                i = Pai(i);
            }
        }
    }
    
    public void min_heapInsert(FilaMinima fila, int chave){
        fila.tam_heap += 1;
        //fila.comp += 1;
        //na minha opinião deveria incrementar o comprimento do heap tbm... mas no livro não informa
        fila.vertice[fila.tam_heap - 1].valor = Integer.MAX_VALUE;
        fila.heap_increaseKey(fila, (fila.tam_heap - 1), chave);
        
    }
    
}
