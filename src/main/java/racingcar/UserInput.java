package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private int repeat;
    private List<String> carNameList;

    public UserInput() {
        this.repeat = 0;
        this.carNameList = new ArrayList<>();
    }

    public void initialize() {

    }

    public void run() {
        carNameInput();
        repeatInput();
    }

    public void finish() {
        Console.close();
    }

    private void carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameLine = Console.readLine();
        String[] carNames = carNameLine.split(",");
        for (String carName : carNames) {
            carNameValidate(carName);
            this.carNameList.add(carName);
        }
    }

    private void carNameValidate(String carName) {
        if (carName.length() > 6) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.");
        }

        if (carNameList.contains(carName)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

    }

    private void repeatInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String userInput = Console.readLine();
        repeatValidate(userInput);
        this.repeat = Integer.parseInt(userInput);
    }

    private void repeatValidate(String userInput) {
        if (userInput == null || userInput.isEmpty() || !userInput.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("자연수만 입력할 수 있습니다.");
        }

        if (userInput.length() > 5) {
            throw new IllegalArgumentException("입력 값이 10만 미만이어야합니다.");
        }
    }
}
