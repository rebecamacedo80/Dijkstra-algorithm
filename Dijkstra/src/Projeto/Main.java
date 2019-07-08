package Projeto;

import java.io.IOException;


/**
 *
 * @author rebeca, lucas
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Grafo g = new Grafo("dij40.txt");
        
        g.ListaAdj = g.crialistAdj(g.matrizAdj);        
        g.preencheVertice();
        g.djkstra(g.vertices[0]);
    }
}
