package timeplanner.adapter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import timeplanner.application.model.TaskPriority;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Task entity
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
@Entity
@Setter
@Getter
@Table(name = "TASKS")
public class TaskEntity {
    @Id
    @Column(name = "ID")
    @JdbcTypeCode(Types.VARCHAR)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRIORITY")
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Column(name = "ESTIMATION")
    private String estimation;

    @Column(name = "DEADLINE")
    private LocalDateTime deadline;
}
