package gallery.service.impl;

import gallery.model.Gallery;
import gallery.repository.GalleryRepository;
import gallery.service.IGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GalleryServiceImpl implements IGalleryService {

    @Autowired
   private GalleryRepository galleryRepository;


    @Override
    public List<Gallery> findAllGalleries() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery createGallery(Gallery gallery) {

        if(!gallery.getName().startsWith("WhiteC")||gallery.getMaxCapacity()<=99) {
            throw new IllegalArgumentException("Shop name must begin with 'WhiteC'"+
                    " and maximum capacity should be equal or greater than 100");
        }

        Gallery toDBGallery = new Gallery("new", 0);
        toDBGallery.setName(gallery.getName());
        toDBGallery.setMaxCapacity(gallery.getMaxCapacity());

        return galleryRepository.save(toDBGallery);
    }
}
