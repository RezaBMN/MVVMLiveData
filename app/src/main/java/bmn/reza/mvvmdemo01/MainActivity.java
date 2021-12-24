package bmn.reza.mvvmdemo01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Note> noteList = new ArrayList<>();
    NoteViewModel model;
    NoteAdapter adapter;
    RecyclerView rv;
    EditText editText;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etMain);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        rv = findViewById(R.id.recyclerView);

        model = new ViewModelProvider(this).get(NoteViewModel.class);


        model.init();

//        model.getNote().observe(this, new Observer<List<Note>>() {
//            @SuppressLint("NotifyDataSetChanged")
//            @Override
//            public void onChanged(List<Note> notes) {
//                adapter.notifyDataSetChanged();
//            }
//        });


        fab.setOnClickListener(v -> {
            if (!editText.getText().toString().equals("")) {
                model.addNewValue(getNote());
                editText.setText("");
            } else Toast.makeText(this, "Enter text.....", Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        });

        initRecyclerView();
    }

    public void initRecyclerView() {
        adapter = new NoteAdapter(model.getNote().getValue());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    private Note getNote() {
        String note = editText.getText().toString();
        Note note1 = new Note();
        note1.setNote(note);
        return note1;
    }
}