package tarot.journal.domain.boundary;

import tarot.journal.domain.models.Notebook;
import tarot.journal.domain.models.NotebookDetails;

public interface OpenNotebook {
    class RequestData {
        private NotebookDetails details;

        public RequestData(NotebookDetails details) {
            this.details = details;
        }

        public NotebookDetails getDetails() {
            return details;
        }
    }

    class ResponseData {
        private Notebook notebook;

        public ResponseData(Notebook notebook) {
            this.notebook = notebook;
        }

        public Notebook getNotebook() {
            return notebook;
        }
    }

    interface RequestHandler {
        void handleRequest(RequestData requestData, ResponseHandler responseHandler);
    }

    interface ResponseHandler {
        void handleResponse(ResponseData responseData);
    }
}
