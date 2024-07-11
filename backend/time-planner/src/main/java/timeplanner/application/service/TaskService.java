package timeplanner.application.service;

import timeplanner.application.model.TaskDTO;
import timeplanner.application.model.TaskPriority;

import java.util.List;
import java.util.UUID;

/**
 * Task service
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
public interface TaskService {

    void addTask(TaskDTO taskDTO);

    void deleteTask(UUID id);

    void updateTask(TaskDTO taskDTO);

    TaskDTO getTask(UUID id);

    List<TaskDTO> getAllTasks();

    void updateTaskPriority(UUID id, TaskPriority priority);
}
