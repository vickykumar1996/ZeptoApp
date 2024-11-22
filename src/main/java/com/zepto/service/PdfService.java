package com.zepto.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.zepto.entites.Booking;
import com.zepto.entites.Grocery;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;

@Service
public class PdfService {

    public void generatePdf(String filePath , Grocery grocery , Booking booking){
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            PdfPTable pdfPTable = new PdfPTable(2);
            pdfPTable.addCell("GroceryName");
            pdfPTable.addCell(grocery.getGroceryName());
            pdfPTable.addCell("Grocery Price");
            pdfPTable.addCell(String.valueOf(grocery.getGroceryPrice()));
            pdfPTable.addCell("Booking Name");
            pdfPTable.addCell(booking.getName());
            document.add(pdfPTable);
            document.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
