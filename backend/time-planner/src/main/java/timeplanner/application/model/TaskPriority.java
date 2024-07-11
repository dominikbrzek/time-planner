package timeplanner.application.model;

import lombok.Getter;

/**
 * Task priority
 * <br>
 * <p/>
 * Creation date: 11.07.2024<br>
 *
 * @author dominik.brzek
 */
@Getter
public enum TaskPriority {
    IMPORTANT_AND_URGENT(1), IMPORTANT_AND_NOT_URGENT(2), NOT_IMPORTANT_AND_URGENT(3), NOT_IMPORTANT_AND_NOT_URGENT(4);

    private final int value;

    TaskPriority(int priority) {
        this.value = priority;
    }
}
