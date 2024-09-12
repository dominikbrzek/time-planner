package timeplanner.application;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Dodaj nowe podzadanie")
    public ResponseEntity<Void> addSubtask(@RequestBody SubtaskDTO subtaskDTO) {
        service.addSubtask(subtaskDTO);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    @Operation(summary = "Zmodyfikuj istniejące podzadanie")
    public ResponseEntity<Void> updateSubtask(@RequestBody SubtaskDTO taskDTO) {
        service.updateSubtask(taskDTO);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Usuń istniejące podzadanie")
    public ResponseEntity<Void> deleteSubtask(@PathVariable("id") UUID id) {
        service.deleteSubtask(id);
        return ResponseEntity.ok(null);
    }
}
