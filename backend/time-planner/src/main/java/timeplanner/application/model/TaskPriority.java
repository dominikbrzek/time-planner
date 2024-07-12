package timeplanner.application.model;

import lombok.Getter;
import org.apache.coyote.BadRequestException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    IMPORTANT_AND_URGENT(1, "Ważne i pilne"),
    IMPORTANT_AND_NOT_URGENT(2, "Ważne ale niepilne"),
    NOT_IMPORTANT_AND_URGENT(3, "Nieważne ale pilne"),
    NOT_IMPORTANT_AND_NOT_URGENT(4, "Nieważne i niepilne");

    private final int value;
    private final String name;

    TaskPriority(int priority, String name) {
        this.value = priority;
        this.name = name;
    }

    public static TaskPriority fromName(String name) {
        return Arrays.stream(values()).filter(e -> Objects.equals(e.name, name)).findFirst().get();
    }

    public static List<String> getNames() {
        return Arrays.stream(values()).map(TaskPriority::getName).toList();
    }
}
