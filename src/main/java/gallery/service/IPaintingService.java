package gallery.service;

import gallery.model.Painting;

import java.util.List;

public interface IPaintingService {

    List<Painting> findAllPaintingsByGallery (Long galleryId);

    Painting createPainting (Painting painting, Long galleryId);

    void deleteAllPaintingsByGallery (Long galleryId);
}
