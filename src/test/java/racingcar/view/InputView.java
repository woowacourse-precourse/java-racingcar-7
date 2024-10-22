package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class InputView {

    public ArrayList<String> inputCarName() {
        ArrayList<String> carNames = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();

        String[] carArray = cars.split(",");

        for (String car : carArray) {
            carNames.add(car.trim());
        }

        return carNames;

    }

    public String inPutGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String gameCount = Console.readLine();

        return gameCount;
    }
}
