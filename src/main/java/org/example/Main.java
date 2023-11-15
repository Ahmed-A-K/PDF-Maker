package org.example;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import static com.itextpdf.text.FontFactory.*;

public class Main {
    public static void main(String[] args) {
       Document document = new Document();
       try {
           PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("HelloWorld.pdf"));
           document.open();

           //Method to add a paragraph.
           document.add(new Paragraph("A Hello World Pdf Document. This document has some attribute attached to it."));

           //Method to add attribute.
           document.addAuthor("Ahmed Ali Khan");
           document.addCreationDate();
           document.addCreator("Ahmed.com");
           document.addTitle("How to set attributes");
           document.addSubject("This portion of the program show how to add attributes to a PDF.");

           //Adding image to a PDF
           String imgUrl = "https://eclipse.dev/Xtext/xtend/images/java8_logo.png";
           try {
               Image image = Image.getInstance(new URL(imgUrl));
               document.add(image);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

           //Creating a table in the PDF
           PdfPTable table = new PdfPTable(3);
           table.setWidthPercentage(100);
           table.setSpacingBefore(10f);
           table.setSpacingAfter(10f);
           float[] columnWidths = {1f,1f,1f};
           table.setWidths(columnWidths);

           //Creating cells for the table
           PdfPCell cell1 = new PdfPCell(new Paragraph("Java"));
           cell1.setBorderColor(BaseColor.BLACK);
           cell1.setPaddingLeft(10);
           cell1.setPaddingBottom(10);
           cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

           PdfPCell cell2 = new PdfPCell(new Paragraph("Jdk 17"));
           cell2.setBorderColor(BaseColor.BLACK);
           cell2.setPaddingLeft(10);
           cell1.setPaddingBottom(10);
           cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

           PdfPCell cell3 = new PdfPCell(new Paragraph("Released 1996"));
           cell3.setBorderColor(BaseColor.BLACK);
           cell3.setPaddingLeft(10);
           cell1.setPaddingBottom(10);
           cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

           //Adding cells to the table
           table.addCell(cell1);
           table.addCell(cell2);
           table.addCell(cell3);

           //Adding table to the PDF
           document.add(table);

           document.close();
           writer.close();
       } catch (DocumentException e ) {
            e.printStackTrace();
       } catch (FileNotFoundException e ) {
           e.printStackTrace();
       }
    }
}