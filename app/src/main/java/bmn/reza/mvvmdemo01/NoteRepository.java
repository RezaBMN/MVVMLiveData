package bmn.reza.mvvmdemo01;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class NoteRepository {
    private static NoteRepository instance;
    private final ArrayList<Note> dataSet = new ArrayList<>();

    public static NoteRepository getInstance() {
        if (instance == null) {
            instance = new NoteRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Note>> getNotes() {
        MutableLiveData<List<Note>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }
}
