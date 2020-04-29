package Commands;

import java.io.IOException;

/**
 * Интерфейс для всех команд без входных аргументов.
 */
public interface CommandableWithoutArgument extends Commandable {
    void execute() throws IOException;
}
