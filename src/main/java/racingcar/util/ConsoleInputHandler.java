package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements AutoCloseable {

    public String read(String message) {
        System.out.println(message);

        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }

        return input;
    }

    @Override
    public void close() {
        Console.close();
    }
}
