/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import conexion.ConexionBD;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
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

public class ReporteBoletaVenta {
    static ConexionBD cc = new ConexionBD();
    public static Connection cn = cc.conexion();
   // private static final String JASPER_REPORT_PATH = "D:\\reportes\\Proyecto-Ventas-ImportacionesLC\\report-boleta-venta.jasper";
     private static final String JASPER_REPORT_PATH = "/reportes/report-boleta-venta.jasper";
      private static final String JASPER_REPORT_RESUMEN_PATH = "/reportes/report-ventas-clientes.jasper";
   
    public static void generateReporte(String idVenta) {
        try {
            Map parameter = new HashMap();
            parameter.put("ID_VENTA", idVenta);
            
            // Llenar el reporte con los datos de la base de datos y los parámetros
            JasperPrint jasperPrint = JasperFillManager.fillReport(JASPER_REPORT_PATH, parameter, cn);

            // Visualizar el reporte
            
            JasperViewer view = new JasperViewer(jasperPrint,false);
            view.setTitle("BOLETA DE VENTA");
            view.setVisible(true);
        
           // JasperViewer.viewReport(jasperPrint, false);
    
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
    
      public static void generateReporteY(String idVenta) {
        try {
            // Verificar si el archivo existe
            File reportFile = new File(JASPER_REPORT_PATH);
            if (!reportFile.exists()) {
                throw new IllegalArgumentException("El archivo de reporte no se encuentra en el path especificado.");
            }

            // Cargar el reporte compilado (archivo .jasper)
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile);

            // Crear un mapa de parámetros y añadir el parámetro necesario
           // Map<String, Object> parameters = new HashMap<>();
            Map parameters = new HashMap();
       
            parameters.put("ID_VENTA", idVenta);

            // Llenar el reporte con los datos de la base de datos y los parámetros
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, cn);

            // Visualizar el reporte
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setTitle("BOLETA DE VENTA");
            view.setVisible(true);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
      
         public static void generateReporteZ(String idVenta) {
        try {
            // Cargar el reporte compilado (archivo .jasper) desde el classpath
            InputStream reportStream = ReporteBoletaVenta.class.getResourceAsStream(JASPER_REPORT_PATH);

            if (reportStream == null) {
                throw new IllegalArgumentException("El archivo de reporte no se encuentra en el path especificado.");
            }

            // Cargar el reporte desde el InputStream
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);


            if (jasperReport == null) {
                throw new IllegalStateException("El reporte no se pudo cargar correctamente.");
            }

            // Crear un mapa de parámetros y añadir el parámetro necesario
//            Map<String, Object> parameters = new HashMap<>();
//            parameters.put("ID_VENTA", idVenta);
            Map parameters = new HashMap();
       
            parameters.put("ID_VENTA", idVenta);
            
            if (parameters.get("ID_VENTA") == null) {
                throw new IllegalArgumentException("El parámetro ID_VENTA no puede ser nulo.");
            }
            if (cn == null || cn.isClosed()) {
                throw new IllegalStateException("La conexión a la base de datos no está abierta.");
            }
            // Llenar el reporte con los datos de la base de datos y los parámetros
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, cn);

            // Visualizar el reporte
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setTitle("BOLETA DE VENTA");
            view.setVisible(true);

        } catch (JRException e) {
            e.printStackTrace();
            System.err.println("Error al llenar el reporte: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
         
          public static void generateReporteResumen(Date fechaInicio, Date fechaFin) {
        try {
            
              // Cargar el reporte compilado (archivo .jasper) desde el classpath
            InputStream reportStream = ReporteBoletaVenta.class.getResourceAsStream(JASPER_REPORT_RESUMEN_PATH);

            if (reportStream == null) {
                throw new IllegalArgumentException("El archivo de reporte no se encuentra en el path especificado.");
            }

            // Cargar el reporte desde el InputStream
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);


            if (jasperReport == null) {
                throw new IllegalStateException("El reporte no se pudo cargar correctamente.");
            }
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("FECHA_INICIO", fechaInicio);
            parameters.put("FECHA_FIN", fechaFin);
            

            // Visualizar el reporte
            
                        // Llenar el reporte con los datos de la base de datos y los parámetros
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, cn);

            // Visualizar el reporte
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setTitle("RESUMEN DE VENTAS");
            view.setVisible(true);
        
           // JasperViewer.viewReport(jasperPrint, false);
    
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
     
}
