package gallery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;
@Table(name = "paintings")
@Entity
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Value("${default.author:anonymous}")
    private String author;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private LocalDate entrydate=LocalDate.now();

    @ManyToOne()
    @JoinColumn(name="galleries_id")
    @JsonIgnore
    private Gallery gallery;

    private Painting(){}

    public Painting(String author, String title, double price, Gallery gallery) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.gallery = gallery;
    }

    public Painting(String title, double price) {
        this.title = title;
        this.price = price;
    }
    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getEntryDate() {
        return entrydate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entrydate = entrydate;
    }
}
