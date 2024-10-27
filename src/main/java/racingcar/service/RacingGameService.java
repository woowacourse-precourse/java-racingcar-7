package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.RacingCar;

public class RacingGameService {
    private static final Integer NAME_LENGTH_LIMIT = 5;
    private static final int MIN_CAR_COUNT = 2;

    public List<RacingCar> initializeRacingGame(String carNames) {
        validateCarNames(carNames);
        String[] parseCarName = processCarName(carNames);
        return createRacingCars(parseCarName);
    }

    public Integer convertTryCountToInt(String tryCountInString) {
        validateNumericInput(tryCountInString);
        int tryCount = Integer.parseInt(tryCountInString);
        validateTryCount(tryCount);
        return tryCount;
    }

    public List<RacingCar> getWinners(List<RacingCar> racingCars) {
        List<RacingCar> winners = new ArrayList<>();

        // 가장 높은 위치를 찾기
        int maxPosition = 0;
        for (RacingCar car : racingCars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        // 가장 높은 위치에 있는 자동차들 찾기
        for (RacingCar car : racingCars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }


    private List<RacingCar> createRacingCars(String[] parseCarName) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : parseCarName) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    private String[] processCarName(String carNames) {
        String[] parseCarName = carNames.split(",");
        normalizeCarNames(parseCarName);
        return parseCarName;
    }

    private void normalizeCarNames(String[] parseCarName) {
        // 이름에서 공백 제거
        for (int i = 0; i < parseCarName.length; i++) {
            checkNameIsBlankOrEmpty(parseCarName, i);
            parseCarName[i] = parseCarName[i].trim();
        }
    }

    /* -------------------------------------- 시도 횟수 검증 로직 ----------------------------------------------*/
    private void validateNumericInput(String tryCountInString) {
        if (tryCountInString.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("숫자 이외의 문자는 입력할 수 없습니다.");
        }
    }

    private void validateTryCount(Integer tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    /* -------------------------------------- 자동차 이름 검증 로직 ----------------------------------------------*/

    private void validateCarNames(String carNames) {
        checkCarNameIsEmpty(carNames);
        String[] splitCarNames = processCarName(carNames);

        validateCarCount(splitCarNames);
        checkNameLength(splitCarNames);
        checkDuplicateCarName(splitCarNames);
    }

    private static void checkNameLength(String[] splitCarNames) {
        for (String carName : splitCarNames) {
            if (carName.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력 하셔야 합니다.");
            }
        }
    }

    private static void checkDuplicateCarName(String[] splitCarNames) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(splitCarNames));
        if (splitCarNames.length != carNameSet.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복된 이름이 있습니다.");
        }
    }

    private void checkNameIsBlankOrEmpty(String[] parseCarName, int i) {
        if (parseCarName[i].isBlank() || parseCarName[i].isEmpty()) {
            throw new IllegalArgumentException(i + "번 사용자의 자동차 이름이 입력 되지 않았습니다.");
        }
    }


    private void validateCarCount(String[] splitCarNames) {
        if (splitCarNames.length < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 2대 이상 입력해야 합니다.");
        }
    }

    private void checkCarNameIsEmpty(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
    }

}
