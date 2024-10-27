package racingcar.view;

import racingcar.model.InputVal;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingInputView {
    private static final String INPUT_EXPRESSION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇 회인가요?";

    public InputVal inputProcess() {
        String inputString = "";
        int inputCount = 0;

        try {
            System.out.println(INPUT_EXPRESSION);
            inputString = readLine();
            if (inputString.isEmpty()) {
                throw new IllegalArgumentException("입력된 자동차가 없습니다.");
            }

            System.out.println(INPUT_TRY_COUNT);
            inputCount = Integer.parseInt(readLine());

            if (inputCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수형 숫자여야 합니다.");
        }

        return InputVal.create(inputString, inputCount);

    }
}
