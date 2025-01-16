public class Todos {

    private SimpleTask[] tasks = new SimpleTask[0];

    private SimpleTask[] addToArray(SimpleTask[] current, SimpleTask task) {
        SimpleTask[] tmp = new SimpleTask[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = task;
        return tmp;
    }

    public void add(SimpleTask task) {
        tasks = addToArray(tasks, task);
    }

    public SimpleTask[] findAll() {
        return tasks;
    }

    public SimpleTask[] search(String query) {
        SimpleTask[] result = new SimpleTask[0];
        for (SimpleTask task : tasks) {
            if (task.matches(query)) {
                result = addToArray(result, task);
            }
        }
        return result;
    }
}