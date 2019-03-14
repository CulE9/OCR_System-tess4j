package group.ocrsystem;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

@Service
public class OcrService {

    public String doOCR(String url) {
        try {
            URL imageURL = new URL(url);
            BufferedImage bufferedImage = ImageIO.read(imageURL);

            ITesseract instance = new Tesseract();
            instance.setDatapath("C:\\Users\\CulE\\Documents\\IntelliJ IDEA Workspace\\OCR-System\\src\\main\\resources");
//            instance.setDatapath("tessdata");
            instance.setLanguage("pol");

            return instance.doOCR(bufferedImage);
        } catch (Exception e) {
//            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "";
    }
}