package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomPicker {

    static MapBuilder mapBuilder = new MapBuilder();
    static MessagePrinter messagePrinter = new MessagePrinter();

    public static List<String> runRandomRounds(List<String> carNames, int totalRounds) {

        validateNamesAndRounds(carNames, totalRounds);

        String singleRoundResultMessage;
        List<String> totalRoundResultList = new ArrayList<>();

        for(int i = 0; i < totalRounds; i++){
            runSingleRandomRound(carNames);
            singleRoundResultMessage = messagePrinter.getSingleRoundResultMessage(carNames, i);
            totalRoundResultList.add(singleRoundResultMessage);
        }

        return totalRoundResultList;
    }

    public static void runSingleRandomRound(List<String> carNames){

        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            boolean isCarGoForward = validateRandomResult(runRandom());
            mapCarIfForward(carName, isCarGoForward);
        }
    }

    static int runRandom() {
        try {
            int randomInt = Randoms.pickNumberInRange(0,9);
            return randomInt;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private static void validateNamesAndRounds(List<String> carNames, int totalRounds) {
        if(carNames == null || carNames.size() <= 1 || totalRounds <= 0) {
            throw new IllegalArgumentException();
        }
    }

    static boolean validateRandomResult(int randomRunResult) {
        validateRandomRange(randomRunResult);
        return randomRunResult >= 4;
    }

    private static void validateRandomRange(int runRandom) {
        if (runRandom > 9 || runRandom < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void mapCarIfForward(String carName, boolean isCarGoForward) {
        if(isCarGoForward == true) {
            mapBuilder.mapSingleCarForwardResult(carName);
        }
    }
}
