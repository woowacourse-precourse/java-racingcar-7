package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    List<String> carNameList;

    public UserInput() {
        carNameList = new ArrayList<>();
    }

    public void initialize() {

    }

    public void run() {
        carNameInput();
    }

    public void finish() {
        Console.close();
    }

    private void carNameInput() {
        String carNameLine = Console.readLine();
        String[] carNames = carNameLine.split(",");
        for (String carName : carNames) {
            validate(carName);
            this.carNameList.add(carName);
        }
    }

    private void validate(String carName) {
        if (carName.length() > 6) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.");
        }

        if (carNameList.contains(carName)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

    }
}
