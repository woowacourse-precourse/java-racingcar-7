package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;

public class RacingGame {
    private final LinkedHashMap<String, Integer> carNameAndScore;
    private final int tryCount;

    public RacingGame(LinkedHashMap<String, Integer> carScore, int tryCount) {
        this.carNameAndScore = CarInformation.getCarInformation();
        this.tryCount = Input.inputTryCount();
    }

    public void randomMove() {

        for(int i=0;i<tryCount;i++) {
            for(String car : carNameAndScore.keySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);

                if(randomNumber >= 4) {
                    carNameAndScore.put(car, carNameAndScore.get(car) + 1);
                }
            }
        }
    }
}
