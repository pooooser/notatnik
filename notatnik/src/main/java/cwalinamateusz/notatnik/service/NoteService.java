package cwalinamateusz.notatnik.service;

import cwalinamateusz.notatnik.model.Note;
import cwalinamateusz.notatnik.model.Notebook;
import cwalinamateusz.notatnik.repo.NoteRepo;
import cwalinamateusz.notatnik.repo.NotebookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    NoteRepo noteRepo;
    NotebookService notebookService;

    @Autowired
    public NoteService(NoteRepo noteRepo,NotebookService notebookService) {
        this.noteRepo = noteRepo;
        this.notebookService=notebookService;
    }

    public NoteService() {
    }

    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    public Optional<Note> getNoteById(long id) {
        return noteRepo.findById(id);
    }

    public void deleteNoteById(long id) {
        noteRepo.deleteById(id);
    }

    public void addNote(Note note) {
        noteRepo.save(note);
    }

    public Note getNoteByNotebook(Long notebookId){
        Optional<Notebook> notebook=notebookService.getNotebookById(notebookId);
    }
}
