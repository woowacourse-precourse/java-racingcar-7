package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CarRaceProcessor {

    private CarRaceProcessor() {
    }

    public static Map<String, Integer> setUpRacingCars(final String userDefinedCarNames) {
        final List<String> racingCars = parseCarNames(userDefinedCarNames);
        return initializeRaceStatus(racingCars);
    }

    private static Map<String, Integer> initializeRaceStatus(final List<String> racingCars) {
        final Map<String, Integer> raceStatus = new LinkedHashMap<>();
        for (final String racingCar : racingCars) {
            raceStatus.put(racingCar, 0);
        }
        return raceStatus;
    }

    private static List<String> parseCarNames(final String userDefinedCarNames) {
        final String[] splitCarNames = userDefinedCarNames.split(",");
        final List<String> racingCars = new ArrayList<>();
        for (final String splitCarName : splitCarNames) {
            final String carName = splitCarName.strip().replaceAll("\\s+", "");
            validateCarName(carName);
            racingCars.add(carName);
        }
        return racingCars;
    }

    private static void validateCarName(final String carName) {
        if (isInvalidCarNameLength(carName)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (isInvalidCarNameType(carName)) {
            throw new IllegalArgumentException("자동차 이름은 영문, 숫자, 한글만 가능합니다.");
        }
    }

    private static boolean isInvalidCarNameLength(final String carName) {
        return carName.length() > 5 || carName.isBlank();
    }

    private static boolean isInvalidCarNameType(final String carName) {
        return !carName.matches("[a-zA-Z0-9가-힣]+");
    }

    public static Map<String, Integer> runSingleRound(final Map<String, Integer> raceStatus) {
        for (final Entry<String, Integer> carPositionEntry : raceStatus.entrySet()) {
            final int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                carPositionEntry.setValue(carPositionEntry.getValue() + 1);
            }
        }
        return raceStatus;
    }

    public static List<String> getWinners(final Map<String, Integer> raceStatus) {
        final List<String> winningCars = new ArrayList<>();
        final int maxForwardCount = Collections.max(raceStatus.values());
        for (final Entry<String, Integer> raceStatusEntry : raceStatus.entrySet()) {
            if (raceStatusEntry.getValue().equals(maxForwardCount)) {
                winningCars.add(raceStatusEntry.getKey());
            }
        }
        return winningCars;
    }
}
