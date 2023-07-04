package sg.edu.rp.c346.id22013834.demodatabse;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ListView lv;
    EditText editDesc, editDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);
        editDate = findViewById(R.id.editDate);
        editDesc = findViewById(R.id.editDescription);
        lv = findViewById(R.id.lvTasks);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                String description = editDesc.getText().toString();
                String date = editDate.getText().toString();

                // Insert a task
                db.insertTask(description, date);
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Get the tasks from the database
                ArrayList<Task> tasks = db.getTasks();
                db.close();

                // Display the descriptions in the TextView
                StringBuilder txt = new StringBuilder();
                for (int i = 0; i < tasks.size(); i++) {
                    Task task = tasks.get(i);
                    txt.append(i).append(". ").append(task.getDescription()).append("\n");
                }
                tvResults.setText(txt.toString());

                // Display the tasks in the ListView
                ArrayAdapter<Task> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, tasks);
                lv.setAdapter(adapter);
            }
        });
    }
}

