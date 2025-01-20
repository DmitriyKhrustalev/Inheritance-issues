import java.util.ArrayList;
import java.util.List;

public class Todos {
    private List<Task> tasks = new ArrayList<>(); // Хранение всех задач как Task

    public void add(Task task) { // Метод принимает любой объект типа Task
        tasks.add(task);
    }

    public Task[] findAll() { // Возвращает массив задач
        return tasks.toArray(new Task[0]);
    }

    public Task[] search(String query) { // Поиск по запросу
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.matches(query)) {
                result.add(task);
            }
        }
        return result.toArray(new Task[0]);
    }
}