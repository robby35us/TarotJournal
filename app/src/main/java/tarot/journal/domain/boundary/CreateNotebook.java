package tarot.journal.domain.boundary;

import tarot.journal.domain.models.NotebookDetails;
import tarot.journal.domain.models.NotebookType;

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
