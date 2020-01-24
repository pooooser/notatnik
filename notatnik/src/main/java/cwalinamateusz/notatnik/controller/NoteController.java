package cwalinamateusz.notatnik.controller;

import cwalinamateusz.notatnik.model.Note;
import cwalinamateusz.notatnik.repo.NoteRepo;
import cwalinamateusz.notatnik.service.NoteService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/note")
@CrossOrigin
public class NoteController {
    NoteRepo noteRepo;
    NoteService noteService;

    public NoteController(NoteRepo noteRepo, NoteService noteService) {
        this.noteRepo = noteRepo;
        this.noteService = noteService;
    }

    @GetMapping("/note")
    public List<Note> getAllNotebooks() {
        return noteService.getAllNotes();
    }

    @GetMapping("/note/{id}")
    public Optional<Note> getNotebookById(@PathVariable long id) {
        return noteService.getNoteById(id);
    }

    @DeleteMapping("/note/{id}")
    public void deleteNotebookById(@PathVariable long id) {
        noteService.deleteNoteById(id);
    }

    @PostMapping
    public void addNotebook(@RequestBody Note notebook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        noteService.addNote(notebook);
    }

}
