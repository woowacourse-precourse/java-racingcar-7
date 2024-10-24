package racingcar.feature;

import camp.nextstep.edu.missionutils.Console;

public class InputInfo {

    String[] cars;
    int time;

    public InputInfo() {
        cars = Console.readLine().split(",");

        for (String car : cars) {
            if (car.isBlank() || car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

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
