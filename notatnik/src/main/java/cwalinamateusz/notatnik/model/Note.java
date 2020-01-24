package cwalinamateusz.notatnik.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Note {
    @Id
    private Long id;
    private String name;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notebook notebook;

    public Note(String name, String content, Notebook notebook) {
        this.name = name;
        this.content = content;
        this.notebook = notebook;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Notebook getNotebook() {
        return notebook;
    }
}
