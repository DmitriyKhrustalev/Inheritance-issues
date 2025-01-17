import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleTaskTest {

    @Test
    public void testSearchFindsMultipleTasks() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить другу");
        SimpleTask task2 = new SimpleTask(2, "Купить подарок другу");
        SimpleTask task3 = new SimpleTask(3, "Сходить за продуктами");

        assertTrue(task1.matches("другу"));
        assertTrue(task2.matches("другу"));
        assertFalse(task3.matches("другу"));
    }

    @Test
    public void testSearchFindsOneTask() {
        SimpleTask task = new SimpleTask(1, "Позвонить другу");

        assertTrue(task.matches("Позвонить"));
        assertFalse(task.matches("Купить"));
    }

    @Test
    public void testSearchFindsNoTasks() {
        SimpleTask task = new SimpleTask(1, "Прогулка с собакой");

        assertFalse(task.matches("работа"));
    }
}