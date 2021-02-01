package duke.command;

import java.io.IOException;

import duke.Storage;
import duke.Task;
import duke.TaskList;
import duke.Ui;

public class DeleteCommand extends Command {

    private final int indexToDelete;

    public DeleteCommand(int indexToDelete) {
        this.indexToDelete = indexToDelete;
    }

    @Override
    public void execute(Ui ui, TaskList tasks, Storage storage) {
        Task task = tasks.delete(indexToDelete);
        try {
            storage.saveTasks(tasks);
        } catch (IOException err) {
            this.isExit = true;
        }
        System.out.println("Noted. I've removed this task:");
        System.out.println("\t" + task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
