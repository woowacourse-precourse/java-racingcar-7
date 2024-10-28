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

    private enum InputMessage {
        CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        RACE_COUNT_MESSAGE("시도할 횟수는 몇 회인가요?");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public String getCarName(){
        System.out.println(InputMessage.CAR_NAME_MESSAGE.getMessage());
        String carName = Console.readLine();
        carNameValidator.validate(carName);
        return carName;
    }

    public int getRaceCount() {
        System.out.println(InputMessage.RACE_COUNT_MESSAGE.getMessage());
        String number = Console.readLine();
        Console.close();
        int raceCount = Integer.parseInt(number);
        raceCountValidator.validate(raceCount);
        return raceCount;
    }
}