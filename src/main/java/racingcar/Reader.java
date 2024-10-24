package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
    public static String readInput() {
//        try {
            String input = Console.readLine();
//        } catch (java.util.NoSuchElementException e) {
//            Application.setInput("");
//        }
        System.out.println(input);
        return input;
    }
}