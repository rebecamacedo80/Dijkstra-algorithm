package Projeto;

/**
 *
 * @author rebeca, lucas
 */
public class Main {
    public static void main(String[] args) {
        //Testes
        //      Min_heapfy       [OK]
        //      Build_minHeap    [OK]
        
        // Resultado OK, mas conferir novamente
        //      heap_minimum     [OK]
        //      heap_extractMin  [OK]
        //      heap_increaseKey [OK]
        //      min_heapInsert   [OK]   
        
        
        // TESTES
        FilaMinima fila =  new FilaMinima(10);
        int v[] = {4, 1, 3, 2, 16, 9 ,10, 14, 8, 7};
        fila.fill(fila, v);
        
        System.out.print("Array Original [INPUT]: ");
        fila.show(fila);
        
        fila.Build_MinHeap(fila); // Aqui organiza a fila em Heap de Minimo // talvez ver uma forma de fazer isso já ao instanciar
                                  // porém tem que preencher antes, tem q analisar o que pode ser feito.
        
        System.out.print("Fila de Mínimo Inicial: ");
        fila.show(fila);
        
        // TESTE 1 - Retornar o menor valor (chave) do heap  [HEAP_MINIMUM]
            /*
            System.out.print("Heap Minimo: ");
            System.out.println(fila.heap_minimum(fila));
            */
          
        // TESTE 2 - Remover o mínimo valor(chave) e retornar ele.   [HEAP-EXTRACT-MIN]
            /*
            System.out.println("Extraindo minimo: " + fila.heap_extractMin(fila));
            System.out.print("Fila depois de remover o minimo: ");
            fila.show(fila);
            */
          
        // Teste 3 - Substituir um valor num índice especifico. [HEAP-INCREASE-KEY]
        // parametros heap_increaseKey(fila, indice, valor ou (chave))
            /*
            fila.heap_increaseKey(fila, 4, 5);
            System.out.print("Fila depois de substituir: ");
            fila.show(fila);
            */

        // Teste 4 - Adicionar um valor a mais na fila. [MIN-HEAP-INSERT]
            /*
            fila.min_heapInsert(fila, -1);
            System.out.print("Fila depois de adicionar: ");
            fila.show(fila);
            */
                        
    }
}
