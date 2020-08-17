package gallery.service.impl;

import gallery.model.Gallery;
import gallery.model.Painting;
import gallery.repository.GalleryRepository;
import gallery.repository.PaintingRepository;
import gallery.service.IPaintingService;
import gallery.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaintingServiceImpl implements IPaintingService {

    @Autowired
    private PaintingRepository paintingRepository;

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public List<Painting> findAllPaintingsByGallery(Long galleryId) {

        Optional<Gallery> galleryDB= galleryRepository.findById(galleryId);
        if(galleryDB.isPresent()) return paintingRepository.findPaintingsByGalleryId(galleryId);
        else throw new ResourceNotFoundException("galleries", "id", galleryId);
    }

    @Override
    public Painting createPainting(Painting painting, Long galleryId) {

        if(painting.getTitle().length()<3 ||painting.getPrice()<=50){
            throw new IllegalArgumentException("Title name should cointain at least 3 characters"+
                    "and price should not be greater than 50");
        }

        Painting toDBPainting=new Painting("new", 0);
        toDBPainting.setAuthor(painting.getAuthor());
        toDBPainting.setTitle(painting.getTitle());
        toDBPainting.setPrice(painting.getPrice());
        toDBPainting.setEntryDate(painting.getEntryDate());
        galleryRepository.findById(galleryId)
        .map(gallery -> {
            toDBPainting.setGallery(gallery);
            return toDBPainting;
        }).orElseThrow(()->
                new ResourceNotFoundException("galleries", "id", galleryId));
        return paintingRepository.save(toDBPainting);

    }

    @Override
    public void deleteAllPaintingsByGallery(Long galleryId) {

        List<Painting> paintingList=findAllPaintingsByGallery(galleryId);
        for(Painting p: paintingList) paintingRepository.delete(p);
    }
}
