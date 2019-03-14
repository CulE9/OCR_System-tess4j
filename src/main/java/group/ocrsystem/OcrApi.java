package group.ocrsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OcrApi {

    private final OcrService ocrService;
    private final GraphicRepo graphicRepo;

    @Autowired
    public OcrApi(OcrService ocrService, GraphicRepo graphicRepo) {
        this.ocrService = ocrService;
        this.graphicRepo = graphicRepo;
    }

    @PostMapping("/api/ocr")
    public String doOcr(@RequestBody Graphic graphic) {
        String ocr = ocrService.doOCR(graphic.getUrl());
        ocr = ocr.replace("\n\n", "\n");
        ocr = ocr.replace("\n", " ");
        System.err.println(ocr);
        if (ocr.length() != 0 && ocr.length() < 256) {
            graphic.setContent(ocr);
            graphicRepo.save(graphic);
            return ocr;
        }
        return "Błędny odczyt";
    }

    @GetMapping("/api/ocr")
    public Iterable<Graphic> getGraphic() {
        return graphicRepo.findAll();
    }
}
