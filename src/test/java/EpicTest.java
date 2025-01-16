import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EpicTest {

    @Test
    public void testEpicMatches() {
        String[] subtasks = { "Купить молоко", "Купить хлеб", "Купить яйца" };
        Epic epic = new Epic(1, subtasks);

        assertTrue(epic.matches("молоко")); // Совпадение с одной из подзадач
        assertTrue(epic.matches("хлеб"));  // Совпадение с другой подзадачей
        assertFalse(epic.matches("сахар")); // Нет совпадений
    }

    @Test
    public void testEpicMatchesWithEmptySubtasks() {
        String[] subtasks = {};
        Epic epic = new Epic(2, subtasks);

        assertFalse(epic.matches("что-то")); // Пустой список подзадач, всегда false
    }

    @Test
    public void testEpicMatchesMultipleSubtasks() {
        String[] subtasks = { "Проект документа", "Задача по работе", "Встреча с клиентом" };
        Epic epic = new Epic(3, subtasks);

        assertTrue(epic.matches("Проект"));
        assertTrue(epic.matches("работе"));
        assertTrue(epic.matches("Встреча"));
    }
}