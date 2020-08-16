package gallery.repository;

import gallery.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaintingRepository extends JpaRepository <Painting, Long> {
    List<Painting> findPaintingsByGalleryId(Long galleryId);
}
