package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        String carNames = promptCarName();
        CarNameParser carNameParser = new CarNameParser(carNames);
    }

    private static String promptCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames;
        try {
            carNames = Console.readLine();
        } catch (NoSuchElementException e) {
            System.out.println("올바른 자동차 이름을 입력해 주세요");
            throw new IllegalArgumentException();
        }
        return carNames;
    }
}
