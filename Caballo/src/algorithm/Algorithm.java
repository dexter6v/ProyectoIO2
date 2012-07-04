/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author williams
 */
public class Algorithm {

    int[][] tablero;
    int[] x = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] y = {1, 2, 2, 1, -1, -2, -2, -1};
    boolean existe_camino;

    public boolean validar_posicion(int posx, int posy) {
        if (posx >= 0 && posx < 8 && posy >= 0 && posy < 8) {
            return true;
        }
        return false;
    }

    public int[][] clonar(int[][] tabla) {
        int[][] temp = new int[8][8];
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                temp[j][i] = tabla[j][i];
            }
        }
        return temp;
    }

    public void dfs(int fila, int columna, int orden, int[][] tabla) {
        tabla[fila][columna] = orden;
        if (orden == 10) {
            tablero = tabla;
            existe_camino = true;
            return;
        }
        for (int i = 0; i < 8; i++) {
            int posx = columna + x[i];
            int posy = fila + y[i];
            if (validar_posicion(posx, posy)) {
                if (tabla[posy][posx] == 0) {
                    dfs(posy, posx, orden + 1, clonar(tabla));
                }
            }
        }
    }

    public boolean recorrido_caballo(int fila, int columna) {
        tablero = new int[8][8];
        existe_camino = false;
        dfs(fila, columna, 1, new int[8][8]);
        return existe_camino;
    }
}
