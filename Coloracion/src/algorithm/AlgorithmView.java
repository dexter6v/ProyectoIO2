
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
        
        //prueba
        Algorithm algorithm = new Algorithm();
        int[][] graph =  {
            {-1,1,-1,-1},
            {1,-1,1,1},
            {-1,1,-1,1},
            {-1,1,1,-1}
        };
        int[] color = algorithm.coloracion(graph);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
