package Projeto;

/**
 *
 * @author rebeca, lucas
 */
public class FilaMinima extends Heap{
    
    public FilaMinima(int size) {
        super(size);    
    }
    
    public int heap_minimum(FilaMinima fila){
        return fila.vetor[0];
    }
    
    public int heap_extractMin(FilaMinima fila){
        if(fila.tam_heap < 0){
            System.out.println("error");
        }
        // avaliar se esse bloco de codigo abaixo deve estar dentro de um else
        int minimo = fila.vetor[0];
        fila.vetor[0] = fila.vetor[fila.tam_heap-1];
        fila.tam_heap -= 1;
        fila.Min_heapify(fila, 0);
        return minimo;
    }
    
    public void heap_increaseKey(FilaMinima fila, int i, int chave){
        // a chave é basicamente o conteudo do elemento do array
        if(chave > fila.vetor[i]){
            System.out.println("Erro: a chave inserida é maior que a chave atual");
        }else{
            // avaliar se este bloco dentro do else realmente necessita estar nesta condição
            fila.vetor[i] = chave;
            
            while((i > 0) && (fila.vetor[Pai(i)] > fila.vetor[i])){
                swap(fila, i, Pai(i));
                i = Pai(i);
            }
        }
    }
    
    public void min_heapInsert(FilaMinima fila, int chave){
        fila.tam_heap += 1;
        //fila.comp += 1;
        //na minha opinião deveria incrementar o comprimento do heap tbm... mas no livro não informa
        fila.vetor[fila.tam_heap - 1] = Integer.MAX_VALUE;
        fila.heap_increaseKey(fila, (fila.tam_heap - 1), chave);
        
    }
    
}
