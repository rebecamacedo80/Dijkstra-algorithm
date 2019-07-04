package Projeto;

import java.util.ArrayList;

/**
 *
 * @author rebeca, lucas
 */
public class Vertice {
    static int id_inicial = 0;
    int id;
    int valor;
    Vertice pred;
    ArrayList<Vertice> adjacente;
    
    public Vertice(){
        this.adjacente = new ArrayList<>();
        this.id = id_inicial++;
        this.valor = Integer.MAX_VALUE;
        this.pred = null;
        //this.adjacente = new ArrayList<String>;
    }


}

