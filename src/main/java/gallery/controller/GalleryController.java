package gallery.controller;

import gallery.model.Gallery;
import gallery.service.IGalleryService;
import gallery.service.impl.GalleryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shops")
public class GalleryController {

    @Autowired
    IGalleryService galleryService;

    @GetMapping
    public ResponseEntity<List<Gallery>> getAllGalleries(){
        return ResponseEntity.ok()
                .body(galleryService.findAllGalleries()
                );
    }

    @PostMapping
    public ResponseEntity<Gallery> createGallery(@Valid @RequestBody Gallery gallery){
        return ResponseEntity.ok()
                .body(galleryService.createGallery(gallery));
    }
}

