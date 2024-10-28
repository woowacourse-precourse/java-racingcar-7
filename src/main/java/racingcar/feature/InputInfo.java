package racingcar.feature;

import camp.nextstep.edu.missionutils.Console;

public class InputInfo {

    String[] cars;
    int time;

    public InputInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

        cars = Console.readLine().split(",");

        for (String car : cars) {
            if (car.isBlank() || car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("시도할 횟수는 몇 번인가요?");

        try {
            time = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String[] getCarsName() {
        return cars;
    }

    public int getTime() {
        return time;
    }

}
