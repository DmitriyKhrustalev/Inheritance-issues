import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EpicTest {

    @Test
    public void testSearchFindsMultipleSubtasks() {
        String[] subtasks = {"Купить молоко", "Купить хлеб", "Купить подарок другу"};
        Epic epic = new Epic(1, subtasks);

        assertTrue(epic.matches("Купить"));
        assertTrue(epic.matches("другу"));
        assertFalse(epic.matches("работа"));
    }

    @Test
    public void testSearchFindsOneSubtask() {
        String[] subtasks = {"Купить молоко", "Купить хлеб", "Купить яйца"};
        Epic epic = new Epic(1, subtasks);

        assertTrue(epic.matches("хлеб"));
        assertFalse(epic.matches("сахар"));
    }

    @Test
    public void testSearchFindsNoSubtasks() {
        String[] subtasks = {"Купить молоко", "Купить хлеб", "Купить яйца"};
        Epic epic = new Epic(1, subtasks);

        assertFalse(epic.matches("работа"));
    }
}