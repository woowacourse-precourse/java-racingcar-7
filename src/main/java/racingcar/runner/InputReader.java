package racingcar.runner;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputReader {

    private final int totalReadCnt;
    private int readCnt = 0;

    public InputReader(int totalReadCnt) {
        this.totalReadCnt = totalReadCnt;
    }

    public String getStringWithQuestion(String question) {
        System.out.println(question);
        return get();
    }

    public int getIntegerWithQuestion(String question) {
        System.out.println(question);
        return Integer.parseInt(get());
    }

    public String get() {
        String input = null;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Scanner 호출 횟수가 초과되었습니다.");
        }

        if (++readCnt == totalReadCnt) {
            Console.close();
        }
        return input;
    }
}
