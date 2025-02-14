package timeplanner.application.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


/**
 * Task DTO
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
@Setter
@Getter
public class TaskDTO {

    private UUID id;
    private String title;
    private String description;
    private String priority;
    private LocalDateTime deadline;
    private String estimation;
    private List<SubtaskDTO> subtasks;
}
