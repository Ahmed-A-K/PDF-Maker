package org.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

           document.close();
           writer.close();
       } catch (DocumentException e ) {
            e.printStackTrace();
       } catch (FileNotFoundException e ) {
           e.printStackTrace();
       }
    }
}