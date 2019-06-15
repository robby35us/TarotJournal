package tarot.journal.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotebookManager {
    private List<NotebookDetails> detailsList;
    private Map<NotebookDetails, Notebook> notebooks;

    public NotebookManager() {
        detailsList = new ArrayList<>();
        notebooks = new HashMap<>();
    }

    public List<NotebookDetails> getDetailsList() {
        return detailsList;
    }

    public NotebookDetails createNotebook(String name, NotebookType type) {
        NotebookDetails details = new NotebookDetails(name, NotebookType.BASIC);
        notebooks.put(details, new Notebook());
        detailsList.add(details);
        return details;
    }

    public Notebook getNotebook(NotebookDetails details) {
        return notebooks.get(details);
    }
}

