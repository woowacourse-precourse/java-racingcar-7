package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Arrays;

public class UserInput {

    public String[] racingCarNameInput() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] inputs = readLine().split(",");

        validRacingCarName(inputs);

        return inputs;
    }

    public Integer raceCountInput() {

        System.out.println("시도할 횟수는 몇 회인가요?");

        String raceCount = readLine();

        validRaceCount(raceCount);

        System.out.println();

        return Integer.parseInt(raceCount);
    }

    private void validRacingCarName(String[] inputs) {

        // 입력값이 없는 경우 예외 반환
        if (inputs.length == 0 || inputs[0].trim().isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름이 입력되지 않았습니다.");
        }

        // 마지막이 빈 문자열인 경우 제거
        if (inputs[inputs.length - 1].trim().isEmpty()) {
            inputs = Arrays.copyOf(inputs, inputs.length - 1);
        }

        for (String input : inputs) {
            if (input.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차의 이름은 빈 값이 허용되지 않습니다.");
            }

            if (input.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하입니다.");
            }
        }
    }

    private void validRaceCount(String raceCount) {

        int count;

        try {
            count = Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 숫자가 아닙니다.");
        }

        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 양수여야 합니다.");
        }
    }
}
