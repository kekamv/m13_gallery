package gallery.service;

import gallery.model.Gallery;

import java.util.List;

public interface IGalleryService {

    List<Gallery> findAllGalleries();

    Gallery createGallery (Gallery gallery);

}
