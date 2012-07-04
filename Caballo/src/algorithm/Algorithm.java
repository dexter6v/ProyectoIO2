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
    int filas;
    int columnas;

    public boolean validar_posicion(int posy, int posx) {
        if (posy >= 0 && posy < filas && posx >= 0 && posx < columnas) {
            return true;
        }
        return false;
    }

    public int[][] clonar(int[][] tabla) {
        int[][] temp = new int[filas][columnas];
        for (int j = 0; j < filas; j++) {
            for (int i = 0; i < columnas; i++) {
                temp[j][i] = tabla[j][i];
            }
        }
        return temp;
    }

    public void dfs(int fila, int columna, int orden, int[][] tabla) {
        tabla[fila][columna] = orden;
        if (orden == filas * columnas) {
            tablero = tabla;
            existe_camino = true;
            return;
        }
        for (int i = 0; i < 8; i++) {
            int posx = columna + x[i];
            int posy = fila + y[i];
            if (validar_posicion(posy, posx)) {
                if (tabla[posy][posx] == 0) {
                    dfs(posy, posx, orden + 1, clonar(tabla));
                }
            }
        }
    }

    public boolean recorrido_caballo(int fila, int columna, int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        tablero = new int[this.filas][this.columnas];
        existe_camino = false;
        dfs(fila, columna, 1, new int[this.filas][this.columnas]);
        return existe_camino;
    }
}
