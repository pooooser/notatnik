package cwalinamateusz.notatnik.controller;

import cwalinamateusz.notatnik.model.Notebook;
import cwalinamateusz.notatnik.repo.NotebookRepo;
import cwalinamateusz.notatnik.service.NotebookService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notebooks")
@CrossOrigin
public class NotebookController {
    private NotebookRepo notebookRepository;
    private NotebookService notebookService;


    public NotebookController(NotebookRepo notebookRepository,NotebookService notebookService) {
        this.notebookRepository = notebookRepository;
        this.notebookService = notebookService;

    }

    @GetMapping("/notebooks")
    public List<Notebook> getAllNotebooks() {
        return notebookService.getAllNotebooks();
    }

    @GetMapping("/notebooks/{id}")
    public Optional<Notebook> getNotebookById(@PathVariable long id) {
        return notebookService.getNotebookById(id);
    }

    @DeleteMapping("/notebooks/{id}")
    public void deleteNotebookById(@PathVariable long id) {
        notebookService.deleteNotebookById(id);
    }

    @PostMapping
    public void addNotebook(@RequestBody Notebook notebook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        notebookService.addNotebook(notebook);
    }

}

