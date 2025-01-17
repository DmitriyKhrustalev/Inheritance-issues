import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeetingTest {

    @Test
    public void testSearchFindsMultipleFields() {
        Meeting meeting1 = new Meeting(1, "Обсуждение проекта", "Проект X", "12:00 01.01.2025");
        Meeting meeting2 = new Meeting(2, "Презентация проекта", "Проект Y", "15:00 01.01.2025");

        assertTrue(meeting1.matches("проекта"));
        assertTrue(meeting2.matches("проекта"));
    }

    @Test
    public void testSearchFindsOneField() {
        Meeting meeting = new Meeting(1, "Обсуждение проекта", "Проект X", "12:00 01.01.2025");

        assertTrue(meeting.matches("Обсуждение"));
        assertFalse(meeting.matches("Презентация"));
    }

    @Test
    public void testSearchFindsNoFields() {
        Meeting meeting = new Meeting(1, "Обсуждение проекта", "Проект X", "12:00 01.01.2025");

        assertFalse(meeting.matches("работа"));
    }
}