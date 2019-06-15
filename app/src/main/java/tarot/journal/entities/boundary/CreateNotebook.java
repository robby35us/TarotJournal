package tarot.journal.entities.boundary;

import tarot.journal.entities.Notebook;
import tarot.journal.entities.NotebookDetails;
import tarot.journal.entities.NotebookType;

public interface CreateNotebook {
    class RequestData {
        private String name;
        private NotebookType type;

        public RequestData(String name, NotebookType type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public NotebookType getType() {
            return type;
        }
    }

    class ResponseData {
        private NotebookDetails details;

        public ResponseData(NotebookDetails details) {
            this.details = details;
        }

        public NotebookDetails getDetails() {
            return details;
        }
    }

    interface RequestHandler {
        void handleRequest(RequestData requestData, ResponseHandler responseHandler);
    }

    interface ResponseHandler {
        void handleResponse(ResponseData responseData);
    }
}
