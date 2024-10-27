package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        String input = Console.readLine();

        String[] carNameList = input.split(",");

        for(String car : carNameList) {
            if(car.isEmpty() || car.length() >5) {
                throw new IllegalArgumentException();
            }
        }

    }
}
