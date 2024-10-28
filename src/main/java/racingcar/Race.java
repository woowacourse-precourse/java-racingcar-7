package racingcar;

import utils.ExceptionMessages;
import utils.Splitter;

import java.util.List;

public class Race {
    private final int MIN_PARTICIPANT_COUNT = 2;

    private Cars competingCars;
    public Race(String names) {
        List<String> carNameList = Splitter.splitCarName(names);
        this.competingCars = validateAndJoinCar(carNameList);
    }

    private Cars validateAndJoinCar(List<String> carNameList) {
        if (carNameList.size() < MIN_PARTICIPANT_COUNT) {
            throw new IllegalArgumentException(ExceptionMessages.MINIMUM_TWO_CARS_REQUIRED);
        }
        return new Cars(carNameList);
    }

