package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RacingCar {
    String carNames;
    List<String> carNameList;
    int carNamesSize;
    int tryCount;
    HashMap<String, Integer> raceStatus = new HashMap<>();
    String raceResult;
    int moveCount;
    String resultLog = "";

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

    public void getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        this.tryCount = Integer.parseInt(readLine());
    }

    public void makeRaceStatus() {
        for (String carName : carNameList) {
            raceStatus.put(carName, 0);
        }
    }

    public void updateRaceStatus() {
        for (String key : carNameList) {
            moveCar(key);
            makeResultLog(key);
            makeResultString(key);
            System.out.println(raceResult);
        }
    }

    public void moveCar(String key) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.moveCount = raceStatus.get(key);
            moveCount = moveCount + 1;
            raceStatus.put(key, moveCount);
        }
    }

    public void makeResultLog(String key) {
        for (int i = 0; i < raceStatus.get(key); i++) {
            resultLog = resultLog + "-";
        }
    }
}
