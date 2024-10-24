package racingcar.endpoint;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputInterface implements AutoCloseable {
    public String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException|IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        Console.close();
    }
}
