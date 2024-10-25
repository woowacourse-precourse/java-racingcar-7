package IO;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Input {

    public String inputCars() {

        String car = null;
        try {
            car = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[잘못된 입력] 자동차 이름이 입력되지 않았습니다.");
        }

        return car;
    }

    public String inputAttempt() {

        String attempt = null;
        try {
            attempt = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[잘못된 입력] 시도할 횟수가 입력되지 않았습니다.");
        }

        return attempt;
    }
}
