package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.UserInput;

public class InputView {

    public UserInput prompt() {
        String cars = promptCars();
        String rounds = promptRounds();

        return UserInput.of(cars, rounds);
    }

    private String promptCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return Console.readLine();
    }

    private String promptRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return Console.readLine();
    }
}
