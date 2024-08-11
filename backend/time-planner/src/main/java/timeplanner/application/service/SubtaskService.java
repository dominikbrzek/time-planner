package timeplanner.application.service;

import timeplanner.application.model.SubtaskDTO;

import java.util.UUID;

/**
 * Subtask service
 * <br>
 * <p/>
 * Creation date: 11.08.2024<br>
 *
 * @author dominik.brzek
 */
public interface SubtaskService {

    void addSubtask(SubtaskDTO subtaskDTO);

    void deleteSubtask(UUID id);

    void updateSubtask(SubtaskDTO subtaskDTO);

}
