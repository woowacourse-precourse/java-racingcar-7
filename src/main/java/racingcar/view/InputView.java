package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.ValidationUtils;

public class InputView {
    private InputView() {}  // 인스턴스화 방지

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] carNames = Console.readLine().split(",");
        ValidationUtils.validateCarNames(carNames);
        return carNames;
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int tryCount = Integer.parseInt(Console.readLine());
            ValidationUtils.validateTryCount(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자로 입력해야 합니다.");
        }
    }
}
