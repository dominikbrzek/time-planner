package timeplanner.application;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import timeplanner.application.model.PomodoroConfigDTO;
import timeplanner.application.service.PomodoroService;

/**
 * Pomodoro controller
 * <br>
 * <p/>
 * Creation date: 11.08.2024<br>
 *
 * @author dominik.brzek
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/v1/pomodoro",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PomodoroController {

    private final PomodoroService pomodoroService;

    public PomodoroController(PomodoroService pomodoroService) {
        this.pomodoroService = pomodoroService;
    }

    @GetMapping
    @Operation(summary = "Pobierz ustawienia czasomierza Pomodoro")
    public ResponseEntity<PomodoroConfigDTO> getConfig() {
        return ResponseEntity.ok(pomodoroService.getConfig());
    }

    @PutMapping
    @Operation(summary = "Zmodyfikuj ustawienia czasomierza Pomodoro")
    public ResponseEntity<Void> updateConfig(@RequestBody PomodoroConfigDTO taskDTO) {
        pomodoroService.updateConfig(taskDTO);
        return ResponseEntity.ok(null);
    }

}