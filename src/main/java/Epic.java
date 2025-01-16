import java.util.Arrays;
import java.util.Objects;


public class Epic {
    protected int id;
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        this.id = id;
        this.subtasks = Arrays.copyOf(subtasks, subtasks.length);
    }

    public int getId() {
        return id;
    }

    public String[] getSubtasks() {
        return Arrays.copyOf(subtasks, subtasks.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Epic epic = (Epic) o;
        return id == epic.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}

