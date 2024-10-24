package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public String[] readNamesOfCars() {
        return Console.readLine().split(",");
    }
}
