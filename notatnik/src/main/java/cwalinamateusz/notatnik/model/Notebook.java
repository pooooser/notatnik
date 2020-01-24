package cwalinamateusz.notatnik.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Notebook {
    @Id
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notebook", cascade = CascadeType.ALL)
    private List<Notebook> notebooks;

    public Notebook(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
