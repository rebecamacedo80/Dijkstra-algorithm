package Projeto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author rebeca, lucas
 */
public class Grafo {
    Vertice vertices[];
    int matrizAdj[][];
    List<Vertice> ListaAdj;
    
    public Grafo(String file) throws IOException{
        matrizAdj = Le_arq(file);
    }
    
    
    public List<Vertice> crialistAdj(int[][] matrizAdj){
        
        List<Vertice> minhaLista = new ArrayList<>();
        for(int i = 0; i < matrizAdj.length; i++){
            minhaLista.add(new Vertice());
        }
        //System.out.println(minhaLista.toString());
        //System.out.println(minhaLista.get(0).adjacente);
        
        for(int i = 0; i < minhaLista.size(); i++){
            System.out.println("");
            for(int j = i; j < matrizAdj.length; j++){
                
                if(i == j){
                    continue;
                    
                }
                //System.out.println("No i= " + i + ", j =" + j);
                //System.out.println(i + "," + j);
                minhaLista.get(i).adjacente.add(minhaLista.get(j));
                minhaLista.get(j).adjacente.add(minhaLista.get(i));
            }
        }
                //System.out.println("Minha lista Inteira: " + minhaLista.toString());
                //System.out.println("Meu elemento 0 da lista  adjacentes: " + minhaLista.get(0).adjacente);
                //System.out.println("Meu elemento 1 da lista  adjacentes: " + minhaLista.get(1).adjacente);
                //System.out.println("Meu elemento 2 da lista  adjacentes: " + minhaLista.get(2).adjacente);
                //System.out.println("Meu elemento 1 da lista  adjacentes: " + minhaLista.get(1).adjacente.get(0));
                //System.out.println("Meu elemento 2 da lista  adjacentes: " + minhaLista.get(2).adjacente.get(0));
        
        return minhaLista;
    }
    
    
   public int[][] Le_arq(String file) throws FileNotFoundException, IOException {
        
        String  filename = file;
        String arquivo = "/home/lucas/Documentos/"+filename;
        
        FileReader arq =  new FileReader(arquivo);       
        BufferedReader ler_arq = new BufferedReader(arq);
        
        String linha = ler_arq.readLine();
        linha.replace("\t", " ");
        
        int num_vertices = Integer.parseInt(linha);
        
        matrizAdj = new int[num_vertices][num_vertices];
        
        int tam_vec = 0;
        for(int i = 1; i <= num_vertices; i++){
            tam_vec += (num_vertices - i);
        }
        
        String[] ar;
        int[] vec = new int[tam_vec];
        int aux = 0;
        
        do{
            linha = ler_arq.readLine();
            
            //System.out.println(linha);
            if(linha == null) break;
            String lin;
            lin = linha.replace("\t", " ");
            //ar = lin.split("\t");
            ar = lin.split(" ");
            //System.out.println(Arrays.toString(ar));
            
            for(int i = 0; i< ar.length; i++){
                //System.out.println(ar.length);
                vec[aux] = Integer.parseInt(ar[i]);
                aux++;
            }
                                 
        }while(linha != null);
        
        int aux2 = 0;        
        for(int i = 0; i < matrizAdj.length; i++){
            for(int j = i; j < matrizAdj.length; j++){
                if(i==j){
                    matrizAdj[i][j] = 0;
                }else{
                    matrizAdj[i][j] = vec[aux2];
                    matrizAdj[j][i] = matrizAdj[i][j];
                    aux2++;
                }
            }
        }               
        
        //for só pra printar matriz        
        for(int i = 0; i < matrizAdj.length; i++){
            System.out.println(" ");
            for(int j = 0; j < matrizAdj.length; j++){
                
                System.out.print(matrizAdj[i][j]+"    ");
            }
            
        }
        return matrizAdj;
        
    }
   
    public void preencheVertice(){
        vertices = new Vertice[ListaAdj.size()];
        for(int i = 0; i < ListaAdj.size(); i++){

            vertices[i] = ListaAdj.get(i);
            //System.out.println("Percorre Lista:" + ListaAdj.get(i));
        }
    }
   
   
       public void djkstra(Grafo g, Vertice destino, Vertice origem){
        origem.valor = 0;
        FilaMinima fila = new FilaMinima(g.vertices);
        fila.fill(fila, g.vertices);
        
        int s = 0;
           
        fila.show(fila);
        while(fila.tam_heap != 0){
            fila.Build_MinHeap(fila);
            Vertice u = fila.heap_extractMin(fila);
            
            
            for(int i = 0; i < u.adjacente.size(); i++){
                relax(u, u.adjacente.get(i), g.matrizAdj[u.id][u.adjacente.get(i).id]);
                 
            }
            s = u.valor;
            
        }
        System.out.println("Dijkstra: " + s);
    }
       
       
    
    public void relax(Vertice u, Vertice v, int adj){
        if(v.valor > u.valor + matrizAdj[v.id][u.id]){
            v.valor = u.valor + matrizAdj[v.id][u.id];
            v.pred = u;
        }
    }
    
}
