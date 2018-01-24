/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Controlador.ControladorCliente;
import Dao.DaoCostosComercializacion;
import Dao.DaoCostosInversion;
import Dao.DaoCostosOperacionales;
import Dao.DaoProduccion;
import Dao.DaoValorFacturado;
import java.awt.Frame;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daniel
 */
public class Reportes {

    public Reportes() {
    }
    
    public double costoOperacionalxMes(String loteid, String cliente, String anio, String mes){
        
        int semanaInicial = this.determinarSemanaInicial(mes);
        int duracion = this.determinarDuracion(mes);
        int semanaFinal = semanaInicial + duracion;
        double costoOperacional = 0;
        double[] ValorHora = new double[duracion];
        int[] horasSemana = new int[duracion];
        
        try{
            for (int i = semanaInicial; i < semanaFinal; i++) {
                ResultSet rs = new DaoValorFacturado().consultarValorFacturadoBD(cliente, anio, String.valueOf(i));
                if( rs.next()){
                    ValorHora[i-semanaInicial] = rs.getDouble(6);
                }else{
                    ValorHora[i-semanaInicial] = 0;
                }
            }
        }catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        /****************************************************************************/
        
        for (int i = semanaInicial; i < semanaFinal; i++) {

            horasSemana[i-semanaInicial] = this.horasLaboradasxSemana(loteid, anio, String.valueOf(i));

        }
        
        /****************************************************************************/
        //multiplicaciones
        for (int i = semanaInicial; i < semanaFinal; i++) {

            costoOperacional += horasSemana[i-semanaInicial] * ValorHora[i-semanaInicial] ;
            
        }
        return costoOperacional;
    }
    
    public double costoComercializacionxMes(String loteid, String cliente, String anio, String mes){
        
        int semanaInicial = this.determinarSemanaInicial(mes);
        int duracion = this.determinarDuracion(mes);
        int semanaFinal = semanaInicial + duracion;
        double costoComer = 0;
        
        try{
            for (int i = semanaInicial; i < semanaFinal; i++) {
                ResultSet rs = new DaoCostosComercializacion().consultarCostosComercializacionxSemanaBD(loteid, anio, String.valueOf(i));
                while( rs.next()){
                    costoComer += rs.getDouble(6);
                }
            }
        }catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return costoComer;
    }
    
    public double costoInversionxMes(String loteid, String cliente, String anio, String mes){
        
        int semanaInicial = this.determinarSemanaInicial(mes);
        int duracion = this.determinarDuracion(mes);
        int semanaFinal = semanaInicial + duracion;
        double costoInver = 0;
        
        try{
            for (int i = semanaInicial; i < semanaFinal; i++) {
                ResultSet rs = new DaoCostosInversion().consultarCostosInversionxSemanaBD(loteid, anio, String.valueOf(i));
                while( rs.next()){
                    costoInver += rs.getDouble(6);
                }
            }
        }catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return costoInver;
    }
    
    public Double[] produccionxMes(String loteid, String cliente, String anio, String mes){
        
        int semanaInicial = this.determinarSemanaInicial(mes);
        int duracion = this.determinarDuracion(mes);
        int semanaFinal = semanaInicial + duracion;
        Double[] produccion = new Double[4];
        for (int i = 0; i < 3; i++) {
            produccion[i] = 0.0;
        }
        
        try{
            for (int i = semanaInicial; i < semanaFinal; i++) {
                ResultSet rs = new DaoProduccion().consultarProduccionsxSemanaBD(loteid, anio, String.valueOf(i));
                while( rs.next()){
                    produccion[0] = rs.getDouble(5);
                    produccion[1] = rs.getDouble(6);
                    produccion[2] = rs.getDouble(7);
                    produccion[3] = rs.getDouble(5)+rs.getDouble(6)+rs.getDouble(7);
                }
            }
        }catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return produccion;
    }
    
    public ArrayList<Integer> determinarSemnas(String mes){
        int semanaInicial = this.determinarSemanaInicial(mes);
        int duracion = this.determinarDuracion(mes);
        int semanaFinal = semanaInicial + duracion;
        ArrayList<Integer> semanas = new ArrayList();
        for (int i = semanaInicial; i < semanaFinal; i++) {
               semanas.add(i);
        }
        return semanas;
    }
    
    public int determinarSemanaInicial(String mes){
        /*
        Tabla de meses
        1 mes: 4 semanas
        2 mes:9 semanas
        3 mes: 13 semanas
        4 mes : 18 semanas
        5 mes: 22 semanas
        6 mes: 27 semanas
        7 mes: 31 semanas 
        8 mes: 36 semanas
        9 mes : 40 semanas
        10 mes : 44 semanas
        11 mes : 48 semanas
        12 mes : 52 semanas
        */
        int semanaInicial = 0;
        if (mes.equalsIgnoreCase("enero")) {
            semanaInicial = 1;
        }else if (mes.equalsIgnoreCase("febrero")) {
            semanaInicial = 5;
        }else if (mes.equalsIgnoreCase("marzo")) {
            semanaInicial = 10;
        }else if (mes.equalsIgnoreCase("abril")) {
            semanaInicial = 14;
        }else if (mes.equalsIgnoreCase("mayo")) {
            semanaInicial = 19;
        }else if (mes.equalsIgnoreCase("junio")) {
            semanaInicial = 23;
        }else if (mes.equalsIgnoreCase("julio")) {
            semanaInicial = 28;
        }else if (mes.equalsIgnoreCase("agosto")) {
            semanaInicial = 32;
        }else if (mes.equalsIgnoreCase("septiembre")) {
            semanaInicial = 37;
        }else if (mes.equalsIgnoreCase("octubre")) {
            semanaInicial = 41;
        }else if (mes.equalsIgnoreCase("noviembre")) {
            semanaInicial = 45;
        }else if (mes.equalsIgnoreCase("diciembre")) {
            semanaInicial = 49;
        }
        
        return semanaInicial;
    }
    
    public int determinarDuracion(String mes){
        /*
        Tabla de meses
        1 mes: 4 semanas
        2 mes:9 semanas
        3 mes: 13 semanas
        4 mes : 18 semanas
        5 mes: 22 semanas
        6 mes: 27 semanas
        7 mes: 31 semanas 
        8 mes: 36 semanas
        9 mes : 40 semanas
        10 mes : 44 semanas
        11 mes : 48 semanas
        12 mes : 52 semanas
        */
        int semanaInicial = 0;
        if (mes.equalsIgnoreCase("enero")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("febrero")) {
            semanaInicial = 5;
        }else if (mes.equalsIgnoreCase("marzo")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("abril")) {
            semanaInicial = 5;
        }else if (mes.equalsIgnoreCase("mayo")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("junio")) {
            semanaInicial = 5;
        }else if (mes.equalsIgnoreCase("julio")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("agosto")) {
            semanaInicial = 5;
        }else if (mes.equalsIgnoreCase("septiembre")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("octubre")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("noviembre")) {
            semanaInicial = 4;
        }else if (mes.equalsIgnoreCase("diciembre")) {
            semanaInicial = 4;
        }
        
        return semanaInicial;
    }
    
    public int horasLaboradasxSemana(String loteid, String anio, String semana){
        int horas = 0;
        try {
            ResultSet rs = new DaoCostosOperacionales().consultarCostosOperacionalesxSemanaBD(loteid, anio, semana);
            while( rs.next()){
                horas += rs.getInt(6);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horas;
    }
    
    //generar reporte de ejemplo
    public void generarReporte(){
        
        try {
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("Reportes/reportpr.jasper"));
            JasperReport reporte = JasperCompileManager.compileReport(System.getProperty("user.dir")+"/Jasper/reportpr.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new Conexion.Fachada().conectar_BD());
            JasperViewer view = new JasperViewer(jasperPrint, false);
                view.setTitle("Reporte");
                view.setExtendedState(Frame.MAXIMIZED_BOTH);
                view.setVisible(true);
            
            JRExporter exporter = new JRPdfExporter();
            
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes/reportePDF.pdf"));
            exporter.exportReport(); 
            JasperExportManager.exportReportToPdfFile( jasperPrint, "Reportes/reporteePDF.pdf");
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reporte basico
    public void generarReporteBasico(Map parametros){
        
        try {
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("Reportes/reportpr.jasper"));
            System.err.println(System.getProperty("user.dir")+"\\Jasper\\reporteBasico.jrxml");
            JasperReport reporte = JasperCompileManager.compileReport(System.getProperty("user.dir")+"/Jasper/reporteBasico.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new Conexion.Fachada().conectar_BD());
            JasperViewer view = new JasperViewer(jasperPrint, false);
                view.setTitle("Reporte Basico");
                view.setExtendedState(Frame.MAXIMIZED_BOTH);
                view.setVisible(true);
            
            //JRExporter exporter = new JRPdfExporter();
            
            //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes/reportePDF.pdf"));
            //exporter.exportReport(); 
            //JasperExportManager.exportReportToPdfFile( jasperPrint, "Reportes/reporteePDF.pdf");
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reporte de inversion
    public void generarReporteInversion(Map parametros, List<CostosInversion> listaCostos){
        
        try {
            
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("Reportes/reportpr.jasper"));
            JasperReport reporte = JasperCompileManager.compileReport(System.getProperty("user.dir")+"/Jasper/reporteInv.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,  new JRBeanCollectionDataSource(listaCostos));
            JasperViewer view = new JasperViewer(jasperPrint, false);
                view.setTitle("Reporte Basico");
                view.setExtendedState(Frame.MAXIMIZED_BOTH);
                view.setVisible(true);
            
            //JRExporter exporter = new JRPdfExporter();
            
            //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes/reportePDF.pdf"));
            //exporter.exportReport(); 
            //JasperExportManager.exportReportToPdfFile( jasperPrint, "Reportes/reporteePDF.pdf");
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reporte de comercializacion
    public void generarReporteComercializacion(Map parametros, List<CostosInversion> listaCostos){
        
        try {
            
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("Reportes/reportpr.jasper"));
            JasperReport reporte = JasperCompileManager.compileReport(System.getProperty("user.dir")+"/Jasper/reporteComer.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,  new JRBeanCollectionDataSource(listaCostos));
            JasperViewer view = new JasperViewer(jasperPrint, false);
                view.setTitle("Reporte Basico");
                view.setExtendedState(Frame.MAXIMIZED_BOTH);
                view.setVisible(true);
            
            //JRExporter exporter = new JRPdfExporter();
            
            //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes/reportePDF.pdf"));
            //exporter.exportReport(); 
            //JasperExportManager.exportReportToPdfFile( jasperPrint, "Reportes/reporteePDF.pdf");
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reporte de costos operacionales
    public void generarReporteCoostosOperacionales(Map parametros, List<CostosInversion> listaCostos){
        
        try {
            
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("Reportes/reportpr.jasper"));
            JasperReport reporte = JasperCompileManager.compileReport(System.getProperty("user.dir")+"/Jasper/reporteOper.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,  new JRBeanCollectionDataSource(listaCostos));
            JasperViewer view = new JasperViewer(jasperPrint, false);
                view.setTitle("Reporte Basico");
                view.setExtendedState(Frame.MAXIMIZED_BOTH);
                view.setVisible(true);
            
            //JRExporter exporter = new JRPdfExporter();
            
            //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes/reportePDF.pdf"));
            //exporter.exportReport(); 
            //JasperExportManager.exportReportToPdfFile( jasperPrint, "Reportes/reporteePDF.pdf");
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reporte de Historial de aplicacion
    public void generarReporteHistorialAp(Map parametros, List<CostosInversion> listaCostos){
        
        try {
            
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("Reportes/reportpr.jasper"));
            JasperReport reporte = JasperCompileManager.compileReport(System.getProperty("user.dir")+"/Jasper/reporteHistorialAp.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,  new JRBeanCollectionDataSource(listaCostos));
            JasperViewer view = new JasperViewer(jasperPrint, false);
                view.setTitle("Reporte Basico");
                view.setExtendedState(Frame.MAXIMIZED_BOTH);
                view.setVisible(true);
            
            //JRExporter exporter = new JRPdfExporter();
            
            //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes/reportePDF.pdf"));
            //exporter.exportReport(); 
            //JasperExportManager.exportReportToPdfFile( jasperPrint, "Reportes/reporteePDF.pdf");
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //reporte de Historia clinica
    public void generarReporteHistoriaClinica(Map parametros, List<CostosInversion> listaCostos){
        
        try {
            
            //JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("Reportes/reportpr.jasper"));
            JasperReport reporte = JasperCompileManager.compileReport(System.getProperty("user.dir")+"/Jasper/reporteHistoriaClinica.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,  new JRBeanCollectionDataSource(listaCostos));
            JasperViewer view = new JasperViewer(jasperPrint, false);
                view.setTitle("Reporte Basico");
                view.setExtendedState(Frame.MAXIMIZED_BOTH);
                view.setVisible(true);
            
            //JRExporter exporter = new JRPdfExporter();
            
            //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes/reportePDF.pdf"));
            //exporter.exportReport(); 
            //JasperExportManager.exportReportToPdfFile( jasperPrint, "Reportes/reporteePDF.pdf");
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
