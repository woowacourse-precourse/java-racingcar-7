package racingcar.view;

import racingcar.controller.RacingCarController;
import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.RacingCarErrorMessage;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class UserView {
    private static final String RACING_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REPEAT_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RACING_RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    private final RacingCarController racingCarController;

    public UserView(RacingCarController racingCarController) {
        this.racingCarController = racingCarController;
    }

    public void start() {
        String input = printStart();

        List<Car> cars = getCarsList(input);

        int repeatNumber = printRepeatNumber();

        System.out.println(RACING_RESULT_MESSAGE);

        List<String> winners = racingCarController.start(repeatNumber, cars);

        System.out.println(WINNER_MESSAGE + String.join(", ", winners));
    }

    private String printStart() {
        System.out.println(RACING_START_MESSAGE);

        String input = Console.readLine();

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(RacingCarErrorMessage.START_INPUT_ERROR.getMessage());
        }

        return input;
    }

    private int printRepeatNumber() {
        System.out.println(REPEAT_NUMBER_MESSAGE);

        return getValidRepeatNumber(Console.readLine());
    }

    private int getValidRepeatNumber(String repeatNumber) {
        if (repeatNumber == null || repeatNumber.isBlank()) {
            throw new IllegalArgumentException(RacingCarErrorMessage.BLANK_REPEAT_NUMBER_ERROR.getMessage());
        }

        try {
            int number = Integer.parseInt(repeatNumber.trim());
            if (number <= 0) {
                throw new IllegalArgumentException(RacingCarErrorMessage.POSITIVE_REPEAT_NUMBER_ERROR.getMessage());
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RacingCarErrorMessage.INVALID_REPEAT_NUMBER_ERROR.getMessage());
        }
    }

    private List<Car> getCarsList(String input) {
        List<Car> cars = new ArrayList<>();

        String[] carNames = input.split(",");

        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }

        return cars;
    }

}
