package racingcar.common.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConsoleInput {

    public static final char DEFAULT_DELIMITER = ',';

    public static String readString() {
        return Console.readLine();
    }

    public static List<String> readStrings() {
        return readStrings(DEFAULT_DELIMITER);
    }

    public static List<String> readStrings(char delimiter) {
        List<String> list = getTokenizedStrings(readString(), delimiter);
        return List.copyOf(list);
    }

    private static List<String> getTokenizedStrings(String input, Character delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(input, String.valueOf(delimiter));

        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        return list;
    }

    public static Integer readInteger() {
        return parseIntegerFrom(readString());
    }

    public static List<Integer> readIntegers() {
        return readIntegers(DEFAULT_DELIMITER);
    }

    public static List<Integer> readIntegers(char delimiter) {
        return readStrings(delimiter).stream()
                .map(ConsoleInput::parseIntegerFrom)
                .toList();
    }

    private static Integer parseIntegerFrom(String string) {
        try {
            return Integer.valueOf(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }


}
