package cwalinamateusz.notatnik.service;

import cwalinamateusz.notatnik.model.Notebook;
import cwalinamateusz.notatnik.repo.NotebookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotebookService {
    NotebookRepo notebookRepo;

    public NotebookService() {
    }

    @Autowired
    public NotebookService(NotebookRepo notebookRepo) {
        this.notebookRepo = notebookRepo;
    }


    public List<Notebook> getAllNotebooks() {
        return notebookRepo.findAll();
    }

    public Optional<Notebook> getNotebookById(long id) {
        return notebookRepo.findById(id);
    }

    public void deleteNotebookById(long id) {
        notebookRepo.deleteById(id);
    }

    public void addNotebook(Notebook notebook) {
        notebookRepo.save(notebook);
    }

}
