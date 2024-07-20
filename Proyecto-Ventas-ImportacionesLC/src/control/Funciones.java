/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

public  class Funciones {
    
        public static void ocultarColumnas(JTable table, int[] columnIndices) {
        for (int i : columnIndices) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setMinWidth(0);
            column.setMaxWidth(0);
            column.setPreferredWidth(0);
            column.setResizable(false);
        }
    }
}
