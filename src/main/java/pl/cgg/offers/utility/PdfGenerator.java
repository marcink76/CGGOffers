package pl.cgg.offers.utility;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.service.OfferService;

import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class PdfGenerator {

    private static final String PDF_PATH = "";

    @Autowired
    private OfferService offerService;

    public void makePdf(Long id) throws DocumentException, IOException {

        Offer offer = offerService.getOneOffer(id);

        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(PDF_PATH + id + ".pdf"));

        document.open();

        PdfContentByte canvas = writer.getDirectContent();


        Image image = Image.getInstance("CGG_logo.png");
        //                                                pos X  pos Y
        canvas.addImage(image, 110, 0, 0, 50, 250, 750);

        canvas.beginText();
        canvas.moveText(200, 750);
        canvas.setFontAndSize(BaseFont.createFont(), 10);
        canvas.showText(offer.getDate().toString());
        canvas.endText();

        canvas.beginText();
        canvas.moveText(100, 200);
        canvas.setFontAndSize(BaseFont.createFont(), 14);
        canvas.showText(offer.getDescription() + "to jest tytuł oferty");
        canvas.endText();


//
//        document.add(new Paragraph();
//        document.add(new Paragraph("oferta" + id));
//        document.add(new DottedLineSeparator());
//
//        document.add(new Paragraph(offer.getDescription()));
//        List<ComponentOffer> components = offer.getComponentOfferList();
//
//        for (ComponentOffer component : components) {
//            document.add(new Paragraph(component.getName()));
//        }
        document.close();
    }
}