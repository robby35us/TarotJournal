package tarot.journal.usecases.interactors;

import java.util.ArrayList;

import tarot.journal.domain.boundary.CreateNotebook;
import tarot.journal.domain.gateway.NotebookAccessGateway;
import tarot.journal.domain.boundary.OpenNotebook;
import tarot.journal.usecases.models.InflatedNotebook;
import tarot.journal.usecases.models.NotebookEntry;
import tarot.journal.usecases.boundary.CreateAndOpenNotebook;

public class CreateAndOpenNotebookInteractor implements CreateAndOpenNotebook.RequestHandler,
                                                  CreateNotebook.ResponseHandler,
                                                  OpenNotebook.ResponseHandler {
    private  NotebookAccessGateway gateway;
    private CreateAndOpenNotebook.ResponseHandler outHandler;

    public CreateAndOpenNotebookInteractor() {
        gateway = NotebookAccessGateway.getInstance();
    }


    @Override
    public void handleRequest(CreateAndOpenNotebook.RequestData inRequestData, CreateAndOpenNotebook.ResponseHandler responseHandler) {
        outHandler = responseHandler;
        CreateNotebook.RequestData outRequestData
                = new CreateNotebook.RequestData(inRequestData.getName(), inRequestData.getType());
        gateway.handleRequest(outRequestData, this);
    }

    @Override
    public void handleResponse(CreateNotebook.ResponseData responseData) {
        OpenNotebook.RequestData requestData = new OpenNotebook.RequestData(responseData.getDetails());
        gateway.handleRequest(requestData, this);

    }

    @Override
    public void handleResponse(OpenNotebook.ResponseData responseData) {
        outHandler.handleResponse(
                new CreateAndOpenNotebook.ResponseData(
                        new InflatedNotebook(responseData.getNotebook(), new ArrayList<NotebookEntry>())));
    }
}
