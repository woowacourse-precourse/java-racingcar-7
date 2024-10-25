package racingcar;

import java.nio.channels.ScatteringByteChannel;
import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;


public class InputClass {

    private final String INPUT_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표로 구분)";
    private final String TRY_SENTENCE = "시도할 횟수를 입력하세요.";
    private final Integer MAXIMUN_LIMIT_LENGTH = 6;

    public void inputCarInformation() {
        Scanner sc = new Scanner(System.in);

        System.out.println(INPUT_SENTENCE);
        String[] carNames = Console.readLine().split(",");
        validateCar(carNames);

        System.out.println(TRY_SENTENCE);
        int attemptNumber = validateTryNumber(Console.readLine());

        Racing racing = new Racing();
        for (String carName : carNames) {
            racing.addCar(new Car(carName));
        }
        racing.playRacing(attemptNumber);
    }

    private Integer validateTryNumber(String number) {
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

    private void validateCarNameLength(String car) {
        if (car.length() >= MAXIMUN_LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}

