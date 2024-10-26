package racingcar.input.car.name;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.car.name.CarNameValidator;

public class ConsoleCarNameInput implements CarNameInputHandler {

    private final CarNameValidator carNameValidator;

    public ConsoleCarNameInput(CarNameValidator carNameValidator) {
        this.carNameValidator = carNameValidator;
    }

    @Override
    public String readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = Console.readLine();
        carNameValidator.validate(carNameString);
        return carNameString;
    }
}
