package racingcar;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;


public class InputClass {

    private final String INPUT_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표로 구분)";
    private final String TRY_SENTENCE = "시도할 횟수를 입력하세요.";

    public void inputCarInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.println(INPUT_SENTENCE);
        String[] carNames = sc.nextLine().split(",");
        validateCar(carNames);
        System.out.println(TRY_SENTENCE);
        int attemptNumber = sc.nextInt();

        Racing racing = new Racing();
        for (String carName : carNames) {
            racing.addCar(new Car(carName));
        }
        racing.playRacing(attemptNumber);

        // inputClass에서 racing에게 메세지를 두 개 보낸다.
        // 하나는 addCar라는 퍼블릭 메세지
        // 다른 하나는 playRacing 퍼블릭 메세지
    }

    private void validateCar(String... Cars) {
        for (String car : Cars) {
            validateCarNameLength(car);
        }
    }

    private void validateCarNameLength(String car) {
        if (car.length() >= 6) {
            throw new IllegalArgumentException();
        }
    }
}

