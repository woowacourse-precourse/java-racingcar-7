package view;

import camp.nextstep.edu.missionutils.Console;
import util.validator.Validator;

public class InputView {
    private final Validator<String> carNameValidator;
    private final Validator<Integer> raceCountValidator;

    public InputView(Validator<String> carNameValidator, Validator<Integer> raceCountValidator) {
        this.carNameValidator = carNameValidator;
        this.raceCountValidator = raceCountValidator;
    }

    public String getCarName(){
        System.out.println(Message.CAR_NAME_MESSAGE.getMessage());
        String carName = Console.readLine();
        carNameValidator.validate(carName);
        return carName;
    }

    public int getRaceCount() {
        System.out.println(Message.RACE_COUNT_MESSAGE.getMessage());
        String number = Console.readLine();
        Console.close();
        int raceCount = Integer.parseInt(number);
        raceCountValidator.validate(raceCount);
        return raceCount;
    }
}