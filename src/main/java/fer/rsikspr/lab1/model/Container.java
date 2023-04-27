package fer.rsikspr.lab1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.util.Objects;

@Entity
@Table(name = "Containers")
public class Container {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String image;

    public Container() {
    }

    public Container(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(id, container.id) && Objects.equals(name, container.name) && Objects.equals(image, container.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image);
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
