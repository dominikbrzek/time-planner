package timeplanner.application.model;

import lombok.Getter;
import lombok.Setter;


/**
 * Pomodoro config DTO
 * <br>
 * <p/>
 * Creation date: 11.08.2024<br>
 *
 * @author dominik.brzek
 */
@Setter
@Getter
public class PomodoroConfigDTO {

    private Integer sessionLength;
    private Integer breakLength;
    private Integer roundCount;

    public PomodoroConfigDTO(int sessionLength, int breakLength, int roundCount) {
        this.sessionLength = sessionLength;
        this.breakLength = breakLength;
        this.roundCount = roundCount;
    }
}
