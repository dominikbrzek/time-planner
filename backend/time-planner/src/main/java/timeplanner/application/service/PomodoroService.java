package timeplanner.application.service;

import timeplanner.application.model.PomodoroConfigDTO;

/**
 * Pomodoro service
 * <br>
 * <p/>
 * Creation date: 11.08.2024<br>
 *
 * @author dominik.brzek
 */
public interface PomodoroService {

    void updateConfig(PomodoroConfigDTO configDTO);

    PomodoroConfigDTO getConfig();

}
