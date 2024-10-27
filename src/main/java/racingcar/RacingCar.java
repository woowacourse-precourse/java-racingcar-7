package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.Arrays;
import java.util.List;

public class RacingCar {
    String carNames;
    List<String> carNameList;
    int carNamesSize;

    public void getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.carNames = readLine();
    }

    public void removeBlank() {
        this.carNames = carNames.replaceAll(" ", "");
    }

    public void extractCarNames() {
        this.carNameList = Arrays.asList(carNames.split(","));
        carNamesSize = carNameList.size();
    }
}
