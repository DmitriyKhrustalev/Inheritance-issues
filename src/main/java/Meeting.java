import java.util.Objects;

public class Meeting {
    protected int id;
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String topic, String project, String start) {
        this.id = id;
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return id == meeting.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean matches(String query) {
        if (query == null || query.isEmpty()) {
            return false;
        }
        return topic.contains(query) || project.contains(query);
    }
}
