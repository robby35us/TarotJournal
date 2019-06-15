package tarot.journal.usecases.boundary;

import tarot.journal.domain.models.NotebookType;
import tarot.journal.usecases.models.InflatedNotebook;

public interface CreateAndOpenNotebook {
    class RequestData {
        private String name;
        private NotebookType type;

        public RequestData (String name, NotebookType type) {
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
        private InflatedNotebook notebook;

        public ResponseData (InflatedNotebook notebook) {
            this.notebook = notebook;
        }

        public InflatedNotebook getNotebook() {
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
