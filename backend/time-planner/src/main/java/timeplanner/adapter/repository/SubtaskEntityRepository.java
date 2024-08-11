package timeplanner.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timeplanner.adapter.entity.SubtaskEntity;

import java.util.UUID;

/**
 * Subtask entity repository
 * <br>
 * <p/>
 * Creation date: 11.08.2024<br>
 *
 * @author dominik.brzek
 */
public interface SubtaskEntityRepository extends JpaRepository<SubtaskEntity, UUID> {
}
