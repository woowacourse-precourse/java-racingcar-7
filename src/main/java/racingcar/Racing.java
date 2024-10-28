package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.StringJoiner;

public class Racing {

    //Randoms.pickNumberInRange(0, 9);
    List<Car> racingCar;
    int tryNum;

    public Racing(List<Car> racingCar, int tryNum) {
        this.racingCar = racingCar;
        this.tryNum = tryNum;
    }

    public void game() {
        for (Car car : racingCar) {
            if (go()) {
                int count = car.getCount();
                car.setCount(++count);
            }
        }
    }

    public void show() {
        for (Car car : racingCar) {
            System.out.println(car.getName() + " : ");
            for (int i = 0; i < car.getCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();

    }

    private boolean go() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void winner() {
        StringJoiner winner = new StringJoiner(", ");
        int maxCount = getMaxCount();
        getWinner(maxCount, winner);
        System.out.println("최종 우승자 : " + winner);
    }

    private void getWinner(int max, StringJoiner winner) {
        for (Car car1 : racingCar) {
            if (car1.getCount() == max) {
                winner.add(car1.getName());
            }
        }
    }

    private int getMaxCount() {
        int max = 0;
        for (Car car1 : racingCar) {
            if (car1.getCount() > max) {
                max = car1.getCount();
            }
        }
        return max;
    }
}
