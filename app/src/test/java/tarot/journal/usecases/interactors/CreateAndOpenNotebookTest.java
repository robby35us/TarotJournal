package tarot.journal.usecases.interactors;

import org.junit.Before;
import org.junit.Test;

import tarot.journal.domain.models.NotebookType;
import tarot.journal.usecases.boundary.CreateAndOpenNotebook;
import tarot.journal.usecases.interactors.CreateAndOpenNotebookInteractor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateAndOpenNotebookTest {
    private static final String TEST_NAME = "name";

    private CreateAndOpenNotebookInteractor interactor;

    @Before
    public void canCreateInteractor() {
        interactor = new CreateAndOpenNotebookInteractor();
    }

    @Test
    public void canCreateInflatedNotebook() {
        interactor.handleRequest(new CreateAndOpenNotebook.RequestData(TEST_NAME, NotebookType.BASIC), resultNotNull);
    }

    private CreateAndOpenNotebook.ResponseHandler resultNotNull = new CreateAndOpenNotebook.ResponseHandler() {
        @Override
        public void handleResponse(CreateAndOpenNotebook.ResponseData responseData) {
            assertThat(responseData.getNotebook(), is(notNullValue()));
        }
    };
}
