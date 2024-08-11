package timeplanner.application;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import timeplanner.application.model.SubtaskDTO;
import timeplanner.application.service.SubtaskService;

import java.util.UUID;

/**
 * Subtask controller
 * <br>
 * <p/>
 * Creation date: 11.08.2024<br>
 *
 * @author dominik.brzek
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/v1/subtask",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SubtaskController {

    private final SubtaskService service;

    public SubtaskController(SubtaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> addSubtask(@RequestBody SubtaskDTO subtaskDTO) {
        service.addSubtask(subtaskDTO);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Void> updateSubtask(@RequestBody SubtaskDTO taskDTO) {
        service.updateSubtask(taskDTO);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubtask(@PathVariable("id") UUID id) {
        service.deleteSubtask(id);
        return ResponseEntity.ok(null);
    }
}