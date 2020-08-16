package gallery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Table(name = "galleries")
@Entity
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long maxcapacity;

    @OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Painting> paintings;


    private Gallery(){}

    public Gallery(String name, long maxcapacity) {
        this.name = name;
        this.maxcapacity = maxcapacity;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMaxCapacity() {
        return maxcapacity;
    }

    public void setMaxCapacity(long maxcapacity) {
        this.maxcapacity = maxcapacity;
    }
}
