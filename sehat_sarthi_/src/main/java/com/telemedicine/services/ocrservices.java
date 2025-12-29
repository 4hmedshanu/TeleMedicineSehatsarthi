package com.telemedicine.services;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class ocrservices {
	public String extractText(File imageFile) {
        Tesseract tesseract = new Tesseract();

        // 👇 Use your actual tessdata path (change if installed elsewhere)
        tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata");
        tesseract.setLanguage("eng");  // or "eng+hin" for English + Hindi

        try {
            return tesseract.doOCR(imageFile);
        } catch (TesseractException e) {
            return "Error: " + e.getMessage();
        }
    }
	
	

}
