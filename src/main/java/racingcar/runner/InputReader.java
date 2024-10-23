package racingcar.runner;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    private int cnt;

    public InputReader(int cnt) {
        this.cnt = cnt;
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
        String input = Console.readLine();
        if (cnt-- == 0) {
            Console.close();
        }
        return input;
    }
}
