package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.Constant;
import racingcar.util.ErrorCode;

import java.util.*;
import java.util.stream.Collectors;

public class InputProcessor {

    public void setCarList(Race race, String stringCarList) {
        List<String> splitedCarList = splitAndRmoveEmpty(stringCarList);

        carListValidation(splitedCarList);
        createCarList(race, splitedCarList);
    }

    public void setTotalRound(Race race, String stringMoveCount) {
        moveCountValidation(stringMoveCount);

        int moveCount = Integer.parseInt(stringMoveCount);
        race.setTotalRound(moveCount);
    }

    private void createCarList(Race race, List<String> carList) {
        for (String carName : carList) {
            carNameValidation(carName);
            race.addCar(new Car(carName));
        }
    }

    private void carNameValidation(String carName) {
        if (carName.length() > Constant.MAX_CAR_NAME_LENGTH) {
            throw ErrorCode.INVALID_CAR_NAME.exception();
        }
    }

    private List<String> splitAndRmoveEmpty(String stringCarList) {
        return Arrays.stream(stringCarList.split(Constant.CAR_NAME_DELIMITER))
                .filter(carName -> !carName.isEmpty())
                .map(String::strip)
                .collect(Collectors.toList());
    }

    private void carListValidation(List<String> carList) {
        Set<String> carListSet = new HashSet<>(carList);

        // 중복된 자동차 이름이 있는지 검사
        if (carListSet.size() != carList.size()) {
            throw ErrorCode.DUPLICATE_CAR_NAME.exception();
        }

        // 자동차가 총 1000대 이하인지 검사
        if (carList.size() > Constant.MAX_NUMBER_OF_CARS) {
            throw ErrorCode.CAR_LIMIT_EXCEEDED.exception();
        }
    }

    private void moveCountValidation(String stringMoveCount) {
        // 빈 문자열인지 검사
        if (stringMoveCount == null || stringMoveCount.isEmpty()) {
            throw ErrorCode.INVALD_INPUT.exception();
        }

        // 0부터 10,000 사이의 정수인지 검사
        if (!stringMoveCount.matches(Constant.MOVE_COUNT_CHECK_REGEX)) {
            throw ErrorCode.INVALID_MOVE_COUNT.exception();
        }
    }

}
