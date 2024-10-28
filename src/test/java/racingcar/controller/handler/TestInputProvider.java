package racingcar.controller.handler;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import racingcar.controller.handler.input.InputProvider;

public class TestInputProvider implements InputProvider {

    private final Queue<String> inputQueue = new LinkedList<>();

    public TestInputProvider(String... inputs) {
        Collections.addAll(inputQueue, inputs);
    }

    @Override
    public String readLine() {
        return inputQueue.poll();
    }
}
