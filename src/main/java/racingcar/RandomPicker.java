package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomPicker {

    static MapBuilder mapBuilder = new MapBuilder();
    static MessagePrinter messagePrinter = new MessagePrinter();

    public List<String> runTotalRandom(List<String> carNames, int totalRounds) {
        validateNamesRounds(carNames, totalRounds);

        String singleResultMessage;
        List<String> totalResults = new ArrayList<>();

        for (int i = 0; i < totalRounds; i++) {
            runSingleRandom(carNames);
            singleResultMessage = messagePrinter.getSingleResultMessage(carNames, i);
            totalResults.add(singleResultMessage);
        }

        return totalResults;
    }

    public void runSingleRandom(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            boolean isCarGoForward = validateRandomResult(runRandom());
            mapCarIfForward(carName, isCarGoForward);
        }
    }

    int runRandom() {
        try {
            int randomInt = Randoms.pickNumberInRange(0, 9);
            return randomInt;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void validateNamesRounds(List<String> carNames, int totalRounds) {
        if (carNames == null || carNames.size() <= 1 || totalRounds <= 0) {
            throw new IllegalArgumentException();
        }
    }

    boolean validateRandomResult(int randomRunResult) {
        validateRandomRange(randomRunResult);
        return randomRunResult >= 4;
    }

    private void validateRandomRange(int runRandom) {
        if (runRandom > 9 || runRandom < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void mapCarIfForward(String carName, boolean isCarGoForward) {
        if (isCarGoForward == true) {
            mapBuilder.mapSingleResult(carName);
        }
    }
}
