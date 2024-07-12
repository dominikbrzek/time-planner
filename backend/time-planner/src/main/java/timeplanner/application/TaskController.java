package timeplanner.application;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import timeplanner.application.model.TaskDTO;
import timeplanner.application.model.TaskPriority;
import timeplanner.application.service.TaskService;

import java.util.List;
import java.util.UUID;

/**
 * Task controller
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/v1/task",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @PostMapping
    public ResponseEntity<Void> addTask(@RequestBody TaskDTO taskDTO) {
        taskService.addTask(taskDTO);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Void> updateTask(@RequestBody TaskDTO taskDTO) {
        taskService.updateTask(taskDTO);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") UUID id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/priorities")
    public ResponseEntity<List<String>> getPriorities() {
        return ResponseEntity.ok(TaskPriority.getNames());
    }

}