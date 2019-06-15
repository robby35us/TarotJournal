package tarot.journal.domain.gateway;

import tarot.journal.domain.boundary.CreateNotebook;
import tarot.journal.domain.boundary.OpenNotebook;
import tarot.journal.domain.models.Notebook;
import tarot.journal.domain.models.NotebookDetails;
import tarot.journal.domain.entities.NotebookManager;

public class NotebookAccessGateway implements CreateNotebook.RequestHandler,
        OpenNotebook.RequestHandler {
    private static NotebookAccessGateway gateway;

    private NotebookManager manager;

    public static NotebookAccessGateway getInstance() {
        if(gateway == null)
            gateway = new NotebookAccessGateway();
        return gateway;
    }

    NotebookAccessGateway() {
        manager = new NotebookManager();
    }

    @Override
    public void handleRequest(CreateNotebook.RequestData requestData, CreateNotebook.ResponseHandler responseHandler) {
        NotebookDetails details = manager.createNotebook(requestData.getName(), requestData.getType());
        responseHandler.handleResponse(new CreateNotebook.ResponseData(details));
    }

    @Override
    public void handleRequest(OpenNotebook.RequestData requestData, OpenNotebook.ResponseHandler responseHandler) {
        Notebook notebook = manager.getNotebook(requestData.getDetails());
        responseHandler.handleResponse(new OpenNotebook.ResponseData(notebook));
    }
}
