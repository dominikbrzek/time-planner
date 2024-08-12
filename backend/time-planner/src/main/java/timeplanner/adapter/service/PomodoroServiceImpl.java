package timeplanner.adapter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import timeplanner.application.model.PomodoroConfigDTO;
import timeplanner.application.service.PomodoroService;

/**
 * Task service implementation
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
@Service
public class PomodoroServiceImpl implements PomodoroService {

    private int sessionLength;
    private int breakLength;
    private int roundCount;


    public PomodoroServiceImpl(
            @Value("${properties.default-session-length}") int sessionLength,
            @Value("${properties.default-break-length}") int breakLength,
            @Value("${properties.default-round-count}") int roundCount) {
        this.sessionLength = sessionLength;
        this.breakLength = breakLength;
        this.roundCount = roundCount;
    }

    @Override
    public void updateConfig(PomodoroConfigDTO configDTO) {
        this.sessionLength = configDTO.getSessionLength();
        this.breakLength = configDTO.getBreakLength();
        this.roundCount = configDTO.getRoundCount();
    }

    @Override
    public PomodoroConfigDTO getConfig() {
        return new PomodoroConfigDTO(this.sessionLength, this.breakLength, this.roundCount);
    }
}
