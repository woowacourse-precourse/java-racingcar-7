package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String INPUT_NATE_DELIMITER = ",";

    public List<String> readCarNames() {
        System.out.println("자동차 이름을 입력하세요");
        String input = Console.readLine();
        String[] split = input.split(INPUT_NATE_DELIMITER);

        if (isDuplicated(split)) {
            throw new IllegalArgumentException("동명이인 입력");
        }

        return Arrays.stream(split)
                .map(String::trim)
                .toList();
    }

    private boolean isDuplicated(String[] strings) {
        return Arrays.stream(strings).distinct().count() != strings.length;
    }

    public int readRound() {
        System.out.println("라운드 수를 입력하세요");
        return Integer.parseInt(Console.readLine());
    }

    private void validateRound(String input) {
        try {
            int inputNumber = Integer.parseInt(input);
            if (inputNumber < 1 || inputNumber >= 10000) {
                throw new IllegalArgumentException("라운드 입력은 1만 이하의 양수여야 함");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 함", e);
        }
    }
}
