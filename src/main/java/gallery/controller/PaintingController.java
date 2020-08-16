package gallery.controller;

import gallery.model.Painting;
import gallery.service.IPaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shops")
public class PaintingController {

    @Autowired
    IPaintingService paintingService;

    @GetMapping("/{ID}/pictures")
    ResponseEntity<List<Painting>> getAllPaintingsByGallery(@PathVariable ("ID") long galleryId){
        return ResponseEntity.ok()
                .body(paintingService.findAllPaintingsByGallery(galleryId));

    }

    @PostMapping("/{ID}/pictures")
    public ResponseEntity<Painting> createPainting(@Valid @RequestBody Painting painting,
                                                   @PathVariable("ID") long galleryId){
        return ResponseEntity.ok()
                .body(paintingService.createPainting(painting, galleryId));
    }

    @DeleteMapping("/{ID}/pictures")
    public ResponseEntity deletePaintingsByGallery (@PathVariable("ID") long galleryId){

        paintingService.deleteAllPaintingsByGallery(galleryId);
        return ResponseEntity.ok().build();
    }

}
