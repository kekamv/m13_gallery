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
    private String name;
    @Column(name="max_capacity")
    private long maxCapacity;

    @OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Painting> paintings;


    private Gallery(){}

    public Gallery(String name, long maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
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
        return maxCapacity;
    }

    public void setMaxCapacity(long maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
