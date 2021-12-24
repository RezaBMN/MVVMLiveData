package bmn.reza.mvvmdemo01;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class NoteViewModel extends ViewModel {
    private MutableLiveData<List<Note>> mNote;

    public void init() {
        if (mNote != null) {
            return;
        }
        NoteRepository mRepo = NoteRepository.getInstance();
        mNote = mRepo.getNotes();

    }

    public void addNewValue(final Note note) {
        List<Note> currentNote = mNote.getValue();
        assert currentNote != null;
        currentNote.add(note);
        mNote.postValue(currentNote);
    }

    public LiveData<List<Note>> getNote() {
        return mNote;
    }
}
