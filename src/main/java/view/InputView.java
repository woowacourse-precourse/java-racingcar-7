package view;

import camp.nextstep.edu.missionutils.Console;
import util.validator.CarNameValidator;
import util.validator.RaceCountValidator;

public class InputView {
    private final CarNameValidator carNameValidator;
    private final RaceCountValidator raceCountValidator;

    public InputView(CarNameValidator carNameValidator, RaceCountValidator raceCountValidator) {
        this.carNameValidator = carNameValidator;
        this.raceCountValidator = raceCountValidator;
    }

    public String getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        carNameValidator.validate(carName);
        return carName;
    }

    public int getRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String number = Console.readLine();
        Console.close();
        int raceCount = Integer.parseInt(number);
        raceCountValidator.validate(raceCount);
        return raceCount;
    }
}