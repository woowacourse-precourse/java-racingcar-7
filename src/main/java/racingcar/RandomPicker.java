package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomPicker {

    MapBuilder mapBuilder = new MapBuilder();

    public void runRandomRounds(List<String> carNames, int totalRounds) {
        for(int i = 0; i < totalRounds; i++){
            runSingleRandomRound(carNames);
            mapBuilder.mapSingleRandomRoundResult(i);
        }
    }

    public void runSingleRandomRound(List<String> carNames){
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            boolean isCarGoForward = validateRandomResult(runRandom());
            mapCarIfForward(carName, isCarGoForward);
        }
    }

    private static int runRandom() {
        return Randoms.pickNumberInRange(0,9);
    }

    private static boolean validateRandomResult(int randomRunResult) {
        validateRandomRange(randomRunResult);
        return randomRunResult >= 4;
    }

    private static void validateRandomRange(int runRandom) {
        if (runRandom > 9 || runRandom < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void mapCarIfForward(String carName, boolean isCarGoForward) {
        if(isCarGoForward == true) {
            mapBuilder.mapSingleCarForwardResult(carName);
        }
    }
}
