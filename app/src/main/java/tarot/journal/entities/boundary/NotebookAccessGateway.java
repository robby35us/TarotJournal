package tarot.journal.entities.boundary;

import tarot.journal.entities.NotebookDetails;
import tarot.journal.entities.NotebookManager;

public class NotebookAccessGateway implements CreateNotebook.RequestHandler {
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
}
