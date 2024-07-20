/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import conexion.ConexionBD;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author jmmt
 */
public class ReporteBoletaVenta {
    static ConexionBD cc = new ConexionBD();
    public static Connection cn = cc.conexion();
    private static final String JASPER_REPORT_PATH = "D:\\reportes\\Proyecto-Ventas-ImportacionesLC\\report-boleta-venta.jasper";
    
    public static void generateReporte(String idVenta) {
        try {
            // Cargar el reporte compilado (archivo .jasper)
//            InputStream reportStream = ReporteBoletaVenta.class.getResourceAsStream(JASPER_REPORT_PATH);
//
//            if (reportStream == null) {
//                throw new IllegalArgumentException("El archivo de reporte no se encuentra en el path especificado.");
//            }
             // Cargar el reporte compilado (archivo .jasper)
//            JasperReport jasperReport = JasperCompileManager.compileReport(JASPER_REPORT_PATH);
            // Cargar el reporte desde el InputStream
          //  JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
          
            // Crear un mapa de parámetros y añadir el parámetro necesario
            Map parameter = new HashMap();
            parameter.put("ID_VENTA", 4);
            
            // Llenar el reporte con los datos de la base de datos y los parámetros
            JasperPrint jasperPrint = JasperFillManager.fillReport(JASPER_REPORT_PATH, parameter, cn);

            // Visualizar el reporte
            
            JasperViewer view = null;
            view = new JasperViewer(jasperPrint,false);
            view.setTitle("BOLETA DE VENTA");
            view.setVisible(true);
        
           // JasperViewer.viewReport(jasperPrint, false);
    
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
     
}
