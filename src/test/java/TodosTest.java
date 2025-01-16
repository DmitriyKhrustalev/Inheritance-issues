// Тесты для класса Todos
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    public void testAddAndFindAllTasks() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить другу");
        SimpleTask task2 = new SimpleTask(2, "Сходить за продуктами");
        SimpleTask task3 = new SimpleTask(3, "Прогулка с собакой");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        SimpleTask[] expected = { task1, task2, task3 };
        SimpleTask[] actual = todos.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchFindsMatchingTasks() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить другу");
        SimpleTask task2 = new SimpleTask(2, "Сходить за продуктами");
        SimpleTask task3 = new SimpleTask(3, "Прогулка с собакой");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        SimpleTask[] result = todos.search("Прогулка");
        SimpleTask[] expected = { task3 };

        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchNoMatches() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить другу");
        SimpleTask task2 = new SimpleTask(2, "Сходить за продуктами");
        SimpleTask task3 = new SimpleTask(3, "Прогулка с собакой");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        SimpleTask[] result = todos.search("Работа");
        assertEquals(0, result.length);
    }

    @Test
    public void testAddDuplicateTasks() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить другу");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task1); // Добавляем дубликат

        SimpleTask[] expected = { task1, task1 };
        SimpleTask[] actual = todos.findAll();

        assertArrayEquals(expected, actual);
    }
}