package tarot.journal.entities;


import android.support.annotation.NonNull;

import java.util.Date;

public class NotebookDetails {

    private String name;
    private Date dateCreated;
    private NotebookType type;

    public NotebookDetails(@NonNull String name, @NonNull NotebookType type) {
        this.name = name;
        this.type = type;
        dateCreated = new Date(System.currentTimeMillis());
    }

    public NotebookType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
