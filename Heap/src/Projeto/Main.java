package Projeto;

import java.io.IOException;


/**
 *
 * @author rebeca, lucas
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Grafo g = new Grafo("dij10.txt");
        //g.matrizAdj = g.crialistAdj(g.Le_arq(file));
        //System.out.println(g.matrizAdj[0][1]);
        //System.out.println("A lista: "+ g.ListaAdj);
        //g.crialistAdj(g.matrizAdj);
        g.ListaAdj = g.crialistAdj(g.matrizAdj);
        //System.out.println("Lista ADJ:" + g.ListaAdj);
        g.preencheVertice();
        //System.out.println("Lista de Vertices: ");        
        g.djkstra(g, g.vertices[0]);
    }
}
