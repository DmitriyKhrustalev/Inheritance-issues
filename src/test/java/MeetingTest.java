import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeetingTest {

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(1, "Обсуждение проекта", "Проект X", "12:00 01.01.2025");

        assertTrue(meeting.matches("Обсуждение"));
        assertTrue(meeting.matches("Проект X"));
        assertFalse(meeting.matches("Отдых"));
    }

    @Test
    public void testMeetingMatchesEdgeCases() {
        Meeting meeting = new Meeting(2, "Тестовая тема", "Тестовый проект", "10:00 01.01.2025");

        assertFalse(meeting.matches(""));
        assertFalse(meeting.matches("тестовый"));
        assertTrue(meeting.matches("Тестовый"));
    }

    @Test
    public void testMeetingMatchesWithSpecialCharacters() {
        Meeting meeting = new Meeting(3, "Обсуждение @проекта", "Проект #123", "15:00 10.10.2025");

        assertTrue(meeting.matches("@проекта"));
        assertTrue(meeting.matches("#123"));
        assertFalse(meeting.matches("1234"));
    }
}