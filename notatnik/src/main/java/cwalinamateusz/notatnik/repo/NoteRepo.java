package cwalinamateusz.notatnik.repo;

import cwalinamateusz.notatnik.model.Note;
import cwalinamateusz.notatnik.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note,Long> {
    List<Note> findAllByNotebook(Notebook notebook);
}
