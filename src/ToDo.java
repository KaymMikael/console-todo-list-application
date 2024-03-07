import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDo {
    private ArrayList<Task> tasks = new ArrayList<>();
    private static int id = 0;

    public void showOptions() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please select a valid option");
            System.out.println("1. Add a new task\n2. Display the list of task\n3.Mark task as completed\n4.Remove task from the list\n5.Exit the application");
            int choice = sc.nextInt();
            choices(choice);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            showOptions();
        }
    }

    private void choices(int choice) {
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                showAllTask();
                showOptions();
                break;
            case 3:
                markTask();
                break;
            case 4:
                removeTask();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                showOptions();
        }
    }

    private void chooseMark(int id) {
        boolean doesExists = false;
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setTaskCompleted(true);
                doesExists = true;
                System.out.println("Success.");
                break;
            }
        }
        if (!doesExists) {
            System.out.println("Task doesn't exists in the list.");
        }
        showOptions();
    }

    private void markTask() {
        showAllTask();
        if (tasks.isEmpty()) {
            System.out.println("The List is Empty!");
            showOptions();
        } else {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Please enter the id of the task you want to mark as completed");
                int id = sc.nextInt();
                chooseMark(id);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                markTask();
            }
        }
    }

    private void addTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please add a new task.");
        System.out.print("Description: ");
        String desc = sc.next();
        if (desc.isEmpty()) {
            System.out.println("Please add task.");
            addTask();
        } else {
            id++;
            boolean isCompleted = false;
            Task task = new Task(id, desc, isCompleted);
            addNewTask(task);
            System.out.println("Success.");
            showOptions();
        }
    }


    private void addNewTask(Task t) {
        tasks.add(t);
    }

    private void removeTask() {
        showAllTask();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please enter the id of the task you want to remove from the list.");
            int id = sc.nextInt();
            boolean exists = false;
            for (Task t : tasks) {
                if (id == t.getId()) {
                    exists = true;
                    tasks.remove(t);
                    System.out.println("Removed.");
                    break;
                }
            }
            if (!exists) {
                System.out.println("Task doesn't exists in the list.");
            }
            showOptions();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            removeTask();
        }

    }

    private void showAllTask() {
        if (tasks.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (Task t : tasks) {
                System.out.println(t);
                System.out.println("==============");
            }
        }
    }
}