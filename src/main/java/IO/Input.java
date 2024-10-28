package IO;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Input {

    public String inputCars() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String car = null;
        try {
            car = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[잘못된 입력] 자동차 이름이 입력되지 않았습니다.");
        }

        return car;
    }

    public String inputAttempt() {

        System.out.println("시도할 횟수는 몇 회인가요?");

        String attempt = null;
        try {
            attempt = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[잘못된 입력] 시도할 횟수가 입력되지 않았습니다.");
        }

        return attempt;
    }
}
