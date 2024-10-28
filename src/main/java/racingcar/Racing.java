package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racingcar.exception.ErrorCode.*;

public class Racing {
    private String cars;
    private Integer attemptsCnt;
    private Map<String, String> racingCars;
    private List<String> winnersList;
    private final String DELIMITERS = ",";
    private final String MOVED_ROAD = "-";
    private final String COLON = " : ";
    private final String CAR_NAME_REQUEST_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ATTEMPTS_CNT_REQUEST_TEXT = "시도할 횟수는 몇 회인가요?";
    private final String RESULT_TITLE_TEXT = "\n실행 결과";
    private final String WINNER_TITLE_TEXT = "최종 우승자 : ";

    Racing() {}

    public void input() {
        System.out.println(CAR_NAME_REQUEST_TEXT);
        cars = Console.readLine();
        splitCarsName(cars);

        System.out.println(ATTEMPTS_CNT_REQUEST_TEXT);
        String cntString = Console.readLine();
        validateAttemptsCnt(cntString);
    }

    private void splitCarsName(String cars) {
        String[] carNames = cars.split(DELIMITERS);
        validateCars(carNames);
        makeCarsDict(carNames);
    }

    private void makeCarsDict(String[] carNames) {
        racingCars = new HashMap<>();

        for (String name : carNames) {
            racingCars.put(name, "");
        }
    }

    private void validateCars(String[] carNames) {
        validateCarsCnt(carNames);
        validateCarNameLength(carNames);
    }

    private void validateCarsCnt(String[] carNames) {
        if (carNames.length <= 1) {
            throw new IllegalArgumentException(INVALID_CAR_CNT.getMessage());
        }
    }

    private void validateCarNameLength(String[] carNames) {
        for (String name : carNames) {
            if (name.length() >= 6) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
            }
        }
    }

    private void validateAttemptsCnt(String cntString) {
        attemptsCnt = validateAttemptsCntType(cntString);
        validateAttemptsCntSize(attemptsCnt);
    }

    private void validateAttemptsCntSize(Integer cnt) {
        if (cnt <= 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPTS_CNT.getMessage());
        }
    }

    private Integer validateAttemptsCntType(String cntString) {
        try {
            return Integer.valueOf(cntString);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }

    private void attemptsMoving() {
        System.out.println(RESULT_TITLE_TEXT);
        for (int i = 0; i < attemptsCnt; i++) {
            movingCarsInTurn();
            printCurrent();
        }
    }

    private Integer getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private Boolean isOver4(Integer randomNum) {
        return randomNum >= 4;
    }

    private void moveForward(String name) {
        String current = racingCars.get(name);
        racingCars.put(name, current + MOVED_ROAD);
    }

    private void movingCarsInTurn() {
        for (String name : racingCars.keySet()) {
            Integer randomNum = getRandomNum();
            if (isOver4(randomNum)) {
                moveForward(name);
            }
        }
    }

    private void printCurrent() {
        for (String name : racingCars.keySet()) {
            System.out.println(name + COLON + racingCars.get(name));
        }
        System.out.println();
    }

    private List<String> getWinners() {
        winnersList = new ArrayList<>();

        for (String name : racingCars.keySet()) {
            if (isMaxRacingLength(name)) {
                winnersList.add(name);
            }
        }

        return winnersList;
    }

    private Boolean isMaxRacingLength(String name) {
        Integer maxLength = getMaxRacingLength();
        return getRacingLength(name) == maxLength;
    }

    private Integer getMaxRacingLength() {
        Integer maxRacingLength = 0;

        for (String name : racingCars.keySet()) {
            Integer racingLength = getRacingLength(name);
            if (isBiggerThanMaxLength(racingLength, maxRacingLength)) {
                maxRacingLength = racingLength;
            }
        }

        return maxRacingLength;
    }

    private Integer getRacingLength(String name) {
        return racingCars.get(name).length();
    }

    private Boolean isBiggerThanMaxLength(Integer racingLength, Integer maxLength) {
        return racingLength > maxLength;
    }

    private void printWinner() {
        System.out.print(WINNER_TITLE_TEXT);
        System.out.println(joinWinnerNames());
    }

    private String joinWinnerNames() {
        List<String> winnersList = getWinners();
        return String.join(DELIMITERS, winnersList);
    }

    public void run() {
        input();
        splitCarsName(cars);
        attemptsMoving();
        printWinner();
    }
}
