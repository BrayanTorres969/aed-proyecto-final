package com.pe.biblioteca.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Brayan
 */
public class ReporteExcel {

    public static void generateReport(DefaultTableModel model) {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Prestamos");

        try {
            InputStream is = new FileInputStream("src/main/resources/logito.jpeg");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();

            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();

            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(0);// Ajustar a la primera fila anchor.setRow1(1)
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(1, 3);

            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);

            // Crear un color personalizado con formato RGB
            ((XSSFCellStyle) tituloEstilo).setFillForegroundColor(new XSSFColor(new java.awt.Color(28, 56, 121)));
             tituloEstilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setColor(IndexedColors.WHITE.getIndex());
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 14);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(0);  // Ajustar a la primera fila sheet.createRow(1)
            Cell celdaTitulo = filaTitulo.createCell(0);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de Préstamos");

            sheet.addMergedRegion(new CellRangeAddress(0, 3, 0, 3)); // Ajustar a la primera fila CellRangeAddress(1, 2, 1, 3))
            //(0,3,0,3) -ancho-largo
            String[] cabecera = new String[]{"ID", "Cliente", "Fecha de préstamo", "Fecha de devolución"};

            CellStyle headerStyle = book.createCellStyle();
            //headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            ((XSSFCellStyle) headerStyle).setFillForegroundColor(new XSSFColor(new java.awt.Color(28, 56, 121)));
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(4);

            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            int numFilaDatos = 5;

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);

            // Utiliza el DefaultTableModel proporcionado como parámetro
            for (int fila = 0; fila < model.getRowCount(); fila++) {
                Row filaDatos = sheet.createRow(numFilaDatos);
                int numCol = 0;
                for (int columna = 0; columna < model.getColumnCount(); columna++) {
                    Cell celdaDatos = filaDatos.createCell(numCol++);
                    celdaDatos.setCellStyle(datosEstilo);
                    Object valorCelda = model.getValueAt(fila, columna);
                    celdaDatos.setCellValue(valorCelda != null ? valorCelda.toString() : "");
                }
                numFilaDatos++;
            }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);

            sheet.setColumnWidth(0, 10 * 256);

            sheet.setZoom(150);
            String fileName = "prestamos-biblioteca";
            String home = System.getProperty("user.home");
            File file = new File(home + "/Downloads/" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            book.write(fileOut);
            fileOut.close();

            JOptionPane.showMessageDialog(null, "Reporte Generado");
            Desktop.getDesktop().open(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReporteExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
