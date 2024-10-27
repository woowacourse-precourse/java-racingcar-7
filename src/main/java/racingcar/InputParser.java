package racingcar;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

public class InputParser {
    String delimiter;
    int max_characters;

    InputParser(String delimiter, int max_characters) {
        this.delimiter = delimiter;
        this.max_characters = max_characters;
    }

    public InputResult process() {
        String[] carNames = processCarNames();
        int tryNum = processTryNum();

        return new InputResult(carNames, tryNum);
    }

    private String[] processCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                result.append(input.charAt(i));
            }
        }

        String[] carNames = result.toString().split(delimiter);

        // 글자수 유효성 검증
        for (String carName : carNames) {
            if (carName.length() > max_characters) {
                throw new IllegalArgumentException();
            }
        }

        return carNames;
    }

    private int processTryNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        // 입력 유효성 검증
        int input = parseInt(Console.readLine());
        try {
            if (input < 1) {
                throw new IllegalArgumentException();
            } else {
                return input;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
