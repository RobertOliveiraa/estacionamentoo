/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.FileOutputStream;

import java.io.OutputStream;

import com.itextpdf.text.Document;

import com.itextpdf.text.PageSize;

import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;


/**
 *
 * @author RobertOliveira
 */
public class GerarPdf {

 
08
public class PrimeiroPDF {
09
    public static void main(String[] args) throws Exception {
10
        Document doc = null;
11
        OutputStream os = null;
12
     
13
        try {
14
            //cria o documento tamanho A4, margens de 2,54cm
15
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
16
       
17
            //cria a stream de saída
18
            os = new FileOutputStream("out.pdf");
19
       
20
            //associa a stream de saída ao
21
            PdfWriter.getInstance(doc, os);
22
       
23
            //abre o documento
24
            doc.open();
25
 
26
            //adiciona o texto ao PDF
27
            Paragraph p = new Paragraph("Meu primeiro arquivo PDF!");
28
            doc.add(p);
29
 
30
        } finally {
31
            if (doc != null) {
32
                //fechamento do documento
33
                doc.close();
34
            }
35
            if (os != null) {
36
               //fechamento da stream de saída
37
               os.close();
38
            }
39
        }
40
    }
41
}

}
