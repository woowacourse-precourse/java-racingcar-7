package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private final int totalRaceTurn;
    private final Cars cars = new Cars("pobi,woni,jun");

    public Race(int totalRaceTurn) {
        if (totalRaceTurn <= 0) {
            throw new IllegalArgumentException("자동차 경주는 1회 이상 진행되어야 합니다.");
        }
        this.totalRaceTurn = totalRaceTurn;
    }

    private int pickRandomNumber() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        return pickedNumber;
    }

    private boolean moveForwardOrNot() {
        int pickedNumber = pickRandomNumber();

        if (pickedNumber >= 4) {
            return true;
        }
        return false;
    }

    public String renderScoreBoard() {
        for (int i = 0; i < totalRaceTurn; i++) {
            for (String carName : cars.getCars().keySet()) {
                if (moveForwardOrNot()) {
                    cars.getCars().put(carName, cars.getCars().get(carName) + 1);
                }
            }
        }
        return String.format("pobi : %s\nwoni : %s\njun : %s", "-".repeat(cars.getCars().get("pobi")), "-".repeat(cars.getCars().get("woni")), "-".repeat(cars.getCars().get("jun")));
    }
}
