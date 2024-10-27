package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomPicker {

    MapBuilder mapBuilder = new MapBuilder();
    MessagePrinter messagePrinter = new MessagePrinter();

    public List<String> runRandomRounds(List<String> carNames, int totalRounds) {

        String singleRoundResultMessage;
        List<String> totalRoundResultList = new ArrayList<>();

        for(int i = 0; i < totalRounds; i++){
            runSingleRandomRound(carNames);
            singleRoundResultMessage = messagePrinter.getSingleRoundResultMessage(carNames, i);
            totalRoundResultList.add(singleRoundResultMessage);
        }

        return totalRoundResultList;
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
