/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.*;

/**
 *
 * @author williams
 */
public class Algorithm {

    /**
     * la arista que no exista debe ser marcada con -1 mientras la arista
     * existente debe ser marcada con 1 la numeracion de los nodos inicia con 0
     *
     * @param graph
     * @return int[] con valores mayores a 1 que representa cada uno un color
     */
    public int[] coloracion(int[][] graph) {
        int[] color = new int[graph.length];
        int[] grado = new int[graph.length];
        int[] grado_de_error = new int[graph.length];

        //calculando en grado de cada nodo
        for (int j = 0; j < graph.length; j++) {
            int cont = 0;
            for (int i = 0; i < graph[j].length; i++) {
                if (graph[j][i] == 1) {
                    cont++;
                }
            }
            grado[j] = cont;
        }

        mostrar(grado, "los grados son  ");

        //calculando en grado de error de los nodos
        for (int j = 0; j < graph.length; j++) {
            int cont = 0;
            for (int i = 0; i < graph.length; i++) {
                if (graph[j][i] == 1) {
                    if (grado[i] >= grado[j]) {
                        cont++;
                    }
                }
            }
            grado_de_error[j] = cont + grado[j];
        }

        mostrar(grado, "los grados de error son  ");

        //coloreando
        for (int i = graph.length - 1; i >= 0; i--) {
            //creando lista para los que tienen mismo grado
            List<Integer> mismo_grado = new LinkedList<Integer>();
            for (int j = 0; j < grado.length; j++) {
                if (grado[j] == i) {
                    mismo_grado.add(j);
                }
            }
            if (!mismo_grado.isEmpty()) {
                SortedMap<Integer, List<Integer>> mapa_de_grado =
                        new TreeMap<Integer, List<Integer>>();
                for (Iterator<Integer> it = mismo_grado.iterator(); it.hasNext();) {
                    Integer integer = it.next();
                    if (mapa_de_grado.containsKey(grado_de_error[integer])) {
                        List<Integer> list = mapa_de_grado.get(grado_de_error[integer]);
                        list.add(new Integer(integer));
                        mapa_de_grado.put(grado_de_error[integer], list);
                    } else {
                        List<Integer> list = new LinkedList<Integer>();
                        list.add(integer);
                        mapa_de_grado.put(grado_de_error[integer], list);
                    }
                }
                for (Map.Entry<Integer, List<Integer>> entry : mapa_de_grado.entrySet()) {
                    Integer integer = entry.getKey();
                    List<Integer> list = entry.getValue();
                    for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
                        Integer seleccionado = it.next();
                        SortedSet<Integer> pintados = new TreeSet<Integer>();
                        for (int k = 0; k < graph[seleccionado].length; k++) {
                            if(graph[seleccionado][k]==1 && color[k]!= 0){
                                pintados.add(color[k]);
                            }
                        }
                        for(int k = 1; ;k++){
                            if(!pintados.contains(k)){
                                color[seleccionado]=k;
                                break;
                            }                            
                        }
                    }
                }
            }
        }
        mostrar(color, "respuesta");
        return color;
    }

    void mostrar(int[] vec, String message) {
        System.out.print(message);
        for (int j = 0; j < vec.length; j++) {
            System.out.print(" " + vec[j]);
        }
        System.out.println("");
    }
}
