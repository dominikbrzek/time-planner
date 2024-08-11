package timeplanner.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timeplanner.adapter.entity.TaskEntity;

import java.util.UUID;

/**
 * Task entity repository
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
public interface TaskEntityRepository extends JpaRepository<TaskEntity, UUID> {
}
