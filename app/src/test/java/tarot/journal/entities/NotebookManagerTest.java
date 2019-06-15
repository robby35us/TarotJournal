package tarot.journal.entities;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class NotebookManagerTest {
    private static final String TEST_NOTEBOOK_NAME = "name";

    private NotebookManager manager;

    @Before
    public void createManager() {
        manager = new NotebookManager();
    }

    @Test
    public void newManager_IsEmpty() {
        assertThat(manager.getDetailsList().size(), is(0));
    }

    @Test
    public void canAddNotebook() {
        addOneBasicNotebook();
        assertThat(manager.getDetailsList().size(), is(1));
    }

    @Test
    public void notebook_HasNonNullType() {
        addOneBasicNotebook();
        assertThat(manager.getDetailsList().get(0).getType(), is(notNullValue()));
    }

    @Test
    public void basicNotebook_HasBasicType() {
        addOneBasicNotebook();
        assertThat(manager.getDetailsList().get(0).getType(), is(equalTo(NotebookType.BASIC)));
    }

    private void addOneBasicNotebook() {
        manager.createNotebook(TEST_NOTEBOOK_NAME, NotebookType.BASIC);
    }
}
