package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.validator.CarNameValidator;
import racingcar.validator.CountValidator;

import java.util.List;

public class InputView {

    private String[] names;
    private int count;

    public InputView() {

    }

    public void showInputView() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            names = Console.readLine().trim().split(",");
            CarNameValidator.checkValidNames(names);
            System.out.println("시도할 횟수는 몇 회인가요?");
            String strCount = Console.readLine().trim();
            CountValidator.checkValidCount(strCount);
            count = Integer.parseInt(strCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String[] getCarNames() {
        return names;
    }

    public int getCount() {
        return count;
    }
}
