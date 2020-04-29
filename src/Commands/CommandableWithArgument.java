package Commands;

import java.io.IOException;

/**
 * Интерфейс для всех команд с входными аргументами.
 */
public interface CommandableWithArgument extends Commandable {
    void execute(String arg) throws IOException;
}
