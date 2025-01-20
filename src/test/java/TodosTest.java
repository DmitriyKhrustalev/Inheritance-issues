import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    public void testSearchFindsMultipleTasks() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить другу");
        SimpleTask task2 = new SimpleTask(2, "Купить подарок другу");
        SimpleTask task3 = new SimpleTask(3, "Сходить за продуктами");
        Epic epic = new Epic(4, new String[]{"Купить молоко", "Купить подарок другу"});
        Meeting meeting = new Meeting(5, "Встреча с другом", "Проект X", "12:00 01.01.2025");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("другу");
        Task[] expected = {task1, task2, epic};

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchFindsOneTask() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить маме");
        Epic epic = new Epic(2, new String[]{"Купить молоко", "Купить хлеб"});
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Проект X", "12:00 01.01.2025");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("маме");
        Task[] expected = {task1};

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchFindsNoTasks() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить другу");
        Epic epic = new Epic(2, new String[]{"Купить молоко", "Купить хлеб"});
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Проект X", "12:00 01.01.2025");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("работа");
        Task[] expected = {};

        assertArrayEquals(expected, result);
    }
}
