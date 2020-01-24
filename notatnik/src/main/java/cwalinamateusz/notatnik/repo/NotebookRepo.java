package cwalinamateusz.notatnik.repo;

import cwalinamateusz.notatnik.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepo extends JpaRepository<Notebook,Long> {

}
