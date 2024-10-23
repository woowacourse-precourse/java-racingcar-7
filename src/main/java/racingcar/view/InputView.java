package racingcar.view;

import racingcar.validator.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public String scanCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public int scanTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String stringTryCount = readLine();

        int tryCount = validator.convertTryCountToInt(stringTryCount);
        validator.validTryCount(tryCount);

        return tryCount;
    }
}
