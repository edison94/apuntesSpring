package com.websystique.springmvc.viewresolver;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */



import com.websystique.springmvc.model.Pizza;

public class PdfView extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Pizza pizza = (Pizza) model.get("pizza");

		PdfPTable table = new PdfPTable(3);
		
		table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
         

        // write table header
        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Flavor", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Toppings", font));
        table.addCell(cell);        

		table.addCell(pizza.getName());
		table.addCell(pizza.getFlavor());

		StringBuffer toppings = new StringBuffer("");
		for (String topping : pizza.getToppings()) {
			toppings.append(topping);
			toppings.append(" ");
		}
		table.addCell(toppings.toString());
		document.add(table);

	}

}
