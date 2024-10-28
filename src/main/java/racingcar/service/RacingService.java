package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingService {
    List<String> nameOfCar = new ArrayList<>();
    List<Integer> randomNum = new ArrayList<>();
    List<Integer> movementNum = new ArrayList<>();

    public final OutputService outputService;

    public RacingService(OutputService outputService) {
        this.outputService = outputService;
    }

    public void separateCarNames(String namesOfCars) throws IllegalArgumentException{
        nameOfCar = List.of(namesOfCars.split(","));
        for (String s : nameOfCar) { // movementNum 초기화
            if (s.isBlank()) {
                throw new IllegalArgumentException("이름을 입력하지 않은 자동차가 있습니다.");
            }
            else if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
            }
            else if (Collections.frequency(nameOfCar, s) != 1) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            }
            else if (nameOfCar.size() >= 100) {
                throw new IllegalArgumentException("자동차 개수가 100대 이상입니다.");
            }
            movementNum.add(0);
        }
    }

    public void race(int numberOfRaces) {
        outputService.printStartRacing();
        while (numberOfRaces > 0) {
            randomNum.clear();
            setRandomNum();
            decideStopOrGo();
            outputService.printRacingResults(nameOfCar, movementNum);
            numberOfRaces--;
        }
        outputService.findWinner(movementNum, nameOfCar);
    }

    public void setRandomNum() {
        for (int i=0; i<nameOfCar.size(); i++) {
            int num = Randoms.pickNumberInRange(0,9);
            randomNum.add(num);
        }
    }

    public void decideStopOrGo() {
        for (int i=0; i<randomNum.size(); i++) {
            if (randomNum.get(i) >= 4) {
                int increaseMovementNum = movementNum.get(i)+1;
                movementNum.set(i, increaseMovementNum);
            }
        }
    }
}
