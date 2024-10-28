package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RaceGame {
    public void play() throws IllegalArgumentException {
        String[] carNames = readCarNames();
    }

    private String[] readCarNames() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }
}
