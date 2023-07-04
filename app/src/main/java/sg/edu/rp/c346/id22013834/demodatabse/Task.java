package sg.edu.rp.c346.id22013834.demodatabse;
import androidx.annotation.NonNull;
public class Task {
    private int id;
    private String description;
    private String date;

    public Task(int id, String description, String date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }


    public String getDescription() {
        return description;
    }

    @NonNull
    @Override
    public String toString() {
        return id + "\n" + description + "\n" + date;
    }
}