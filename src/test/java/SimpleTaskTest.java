import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleTaskTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Позвонить маме");
        assertTrue(task.matches("маме"));
        assertFalse(task.matches("папе"));
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = { "Купить молоко", "Купить хлеб", "Купить яйца" };
        Epic epic = new Epic(2, subtasks);
        assertTrue(epic.matches("молоко"));
        assertFalse(epic.matches("сахар"));
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Проект X", "12:00 01.01.2025");
        assertTrue(meeting.matches("Обсуждение"));
        assertTrue(meeting.matches("Проект X"));
        assertFalse(meeting.matches("Отдых"));
    }
}