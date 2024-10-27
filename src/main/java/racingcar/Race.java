package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {
    private final List<Car> CarList;
    private final int Attempt;
    private int CarPosition;

    public Race(List<Car> CarList, int Attempt) {
        this.CarList = CarList;
        this.Attempt = Attempt;
    }

    public void PlayRace() {
        for (int i = 0; i < Attempt; i++) {
            PlayRound();
            System.out.println();
        }
    }

    public void PlayRound() {
        for (Car car : CarList) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                CarPosition++;
            }
            PrintCarPosition(car);
        }
    }

    public void PrintCarPosition(Car car) {
        System.out.println(car.getCarName() + " : " + "-".repeat(CarPosition));
    }
}
