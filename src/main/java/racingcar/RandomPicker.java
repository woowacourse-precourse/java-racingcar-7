package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomPicker {

    public void runSingleRandomRound(List<String> carNames){
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            boolean isCarGoForward = validateRandomResult(runRandom());
            mapCarIfForward(carName, isCarGoForward);
        }
    }

    private static boolean validateRandomResult(int randomRunResult) {
        validateRandomRange(randomRunResult);
        return randomRunResult >= 4;
    }
}
