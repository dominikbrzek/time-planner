package timeplanner.adapter.service;

import org.springframework.stereotype.Service;
import timeplanner.adapter.entity.SubtaskEntity;
import timeplanner.adapter.repository.SubtaskEntityRepository;
import timeplanner.adapter.repository.TaskEntityRepository;
import timeplanner.application.model.SubtaskDTO;
import timeplanner.application.service.SubtaskService;

import java.util.UUID;

/**
 * Subtask service implementation
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
@Service
public class SubtaskServiceImpl implements SubtaskService {

    private final TaskEntityRepository taskRepository;
    private final SubtaskEntityRepository subtaskRepository;

    public SubtaskServiceImpl(SubtaskEntityRepository subtaskRepository, TaskEntityRepository taskRepository) {
        this.subtaskRepository = subtaskRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void addSubtask(SubtaskDTO subtaskDTO) {
        subtaskRepository.save(map(subtaskDTO));
    }

    @Override
    public void deleteSubtask(UUID id) {
        subtaskRepository.deleteById(id);
    }

    @Override
    public void updateSubtask(SubtaskDTO subtaskDTO) {
        SubtaskEntity entity = subtaskRepository.findById(subtaskDTO.getId()).orElseThrow();
        entity.setDescription(subtaskDTO.getDescription());
        entity.setTitle(subtaskDTO.getTitle());
        subtaskRepository.save(entity);
    }

    private SubtaskEntity map(SubtaskDTO dto) {
        SubtaskEntity entity = new SubtaskEntity();
        entity.setTask(taskRepository.findById(dto.getTaskId()).orElseThrow());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
