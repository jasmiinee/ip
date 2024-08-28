package taskon.commands;

import taskon.storage.Storage;
import taskon.task.Task;
import taskon.task.TaskList;
import taskon.task.Todo;
import taskon.ui.Ui;

public class TodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    private Task task;

    public TodoCommand(String description) {
        this.task = new Todo(description);
    }

    public Task getTask() {
        return this.task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(task);
        ui.showTaskAdded(task, taskList.size());
        storage.saveTasks(taskList);
    }
}
