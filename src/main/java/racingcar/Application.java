package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        getInput();
    }

    private static void getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");
        validateCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptsInput = Console.readLine();
        int attempts = Integer.parseInt(attemptsInput);
        validateAttempts(attempts);
    }

    private static void validateCarNames(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
            }
        }
    }

    private static void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomValue = new Random().nextInt(10); // 0~9 랜덤 값 생성
        if (randomValue >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
