package timeplanner.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "UPDATE TaskEntity t SET t.priority = :priority WHERE t.id = :id")
    void updatePriorityById(@Param("id") UUID id, @Param("priority") int priority);
}
