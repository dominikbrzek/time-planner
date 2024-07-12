package timeplanner.adapter.service;

import org.springframework.stereotype.Service;
import timeplanner.adapter.entity.TaskEntity;
import timeplanner.adapter.repository.TaskEntityRepository;
import timeplanner.application.model.TaskDTO;
import timeplanner.application.model.TaskPriority;
import timeplanner.application.service.TaskService;

import java.util.List;
import java.util.UUID;

/**
 * Task service implementation
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskEntityRepository repository;

    public TaskServiceImpl(TaskEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        TaskEntity entity = new TaskEntity();
        updateEntity(entity, taskDTO);
        repository.save(entity);
    }

    @Override
    public void deleteTask(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {
        TaskEntity entity = repository.getReferenceById(taskDTO.getId());
        updateEntity(entity, taskDTO);
        repository.save(entity);
    }

    @Override
    public TaskDTO getTask(UUID id) {
        return mapFromEntity(repository.getReferenceById(id));
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return repository.findAll().stream()
                .map(this::mapFromEntity).toList();
    }

    private TaskDTO mapFromEntity(TaskEntity entity) {
        TaskDTO dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setEstimation(entity.getEstimation());
        dto.setPriority(entity.getPriority().getName());
        dto.setDeadline(entity.getDeadline());
        return dto;
    }

    private void updateEntity(TaskEntity entity, TaskDTO dto) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setDeadline(dto.getDeadline());
        entity.setPriority(TaskPriority.fromName(dto.getPriority()));
        entity.setEstimation(dto.getEstimation());
    }
}
