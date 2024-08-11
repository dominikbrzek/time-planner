package timeplanner.application.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


/**
 * Subtask DTO
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
@Setter
@Getter
public class SubtaskDTO {

    private UUID id;
    private UUID taskId;
    private String title;
    private String description;
}
