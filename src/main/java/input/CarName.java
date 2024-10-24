package input;

import camp.nextstep.edu.missionutils.Console;

public class CarName {
    public String inputCarName() {
        // 원시값 포장 필요
        String carName = Console.readLine();
        return carName;
    }
}
