package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class InputClass {

    private final String INPUT_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표로 구분)";
    private final String TRY_SENTENCE = "시도할 횟수를 입력하세요.";
    private final Integer NAME_MAXIMUM_LIMIT_LENGTH = 6;

    public void inputCarInformation() {
        System.out.println(INPUT_SENTENCE);
        String[] carNames = Console.readLine().split(",");
        validateCar(carNames);

        System.out.println(TRY_SENTENCE);
        int attemptNumber = validateAttemptNumber(Console.readLine());

        Racing racing = new Racing();
        for (String carName : carNames) {
            racing.addCar(new Car(carName));
        }
        racing.playRacing(attemptNumber);
    }

    public Integer validateAttemptNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCar(String... Cars) {
        for (String car : Cars) {
            validateCarNameLength(car);
        }
    }

    public void validateCarNameLength(String car) {
        if (car.length() >= NAME_MAXIMUM_LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}

