package tarot.journal.domain.gateway;

import org.junit.Before;
import org.junit.Test;

import tarot.journal.domain.boundary.CreateNotebook;
import tarot.journal.domain.gateway.NotebookAccessGateway;
import tarot.journal.domain.models.NotebookType;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class NotebookAccessGatewayTest {
    private static final String TEST_NAME = "name";
    private static final NotebookType BASIC_TYPE = NotebookType.BASIC;

    private NotebookAccessGateway gateway;

    @Before
    public void initializeGateway() {
        gateway = new NotebookAccessGateway();
    }

    @Test
    public void createNotebookAction_ReturnsNotNull() {

        gateway.handleRequest(new CreateNotebook.RequestData(TEST_NAME, BASIC_TYPE), notebookNotNull);
    }

    @Test
    public void createNotebookAction_ReturnsExpectedDetails() {
        gateway.handleRequest(new CreateNotebook.RequestData(TEST_NAME, BASIC_TYPE), detailsMatchBasic);
    }

    private CreateNotebook.ResponseHandler notebookNotNull = new CreateNotebook.ResponseHandler() {
        @Override
        public void handleResponse(CreateNotebook.ResponseData responseData) {
            assertThat(responseData.getDetails(), is(notNullValue()));
        }
    };

    private CreateNotebook.ResponseHandler detailsMatchBasic = new CreateNotebook.ResponseHandler() {
        @Override
        public void handleResponse(CreateNotebook.ResponseData responseData) {
            assertThat(responseData.getDetails().getName(), is(equalTo(TEST_NAME)));
            assertThat(responseData.getDetails().getType(), is(equalTo(NotebookType.BASIC)));
        }
    };
}
