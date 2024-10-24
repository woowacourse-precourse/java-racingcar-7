package input;

import camp.nextstep.edu.missionutils.Console;

public class CarName {
    public String inputCarName() {
        // 원시값 포장 필요
        String carName = Console.readLine();
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 적어주세요.");
        }
        return carName;
    }
}
