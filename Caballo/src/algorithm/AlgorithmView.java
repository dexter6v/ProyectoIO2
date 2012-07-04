
package algorithm;

/**
 *
 * @author williams
 */
public class AlgorithmView extends javax.swing.JFrame {

    public AlgorithmView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        AlgorithmView algorithView = new AlgorithmView();
        algorithView.setVisible(true);
        
        Algorithm algorithm = new Algorithm();
        if(algorithm.recorrido_caballo(0, 4)){
            for (int j = 0; j < algorithm.tablero.length; j++) {
                for (int i = 0; i < algorithm.tablero[j].length; i++) {
                    System.out.print(" "+algorithm.tablero[j][i]);
                }
                System.out.println("");
            }
        }
        System.out.println("termino");
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
