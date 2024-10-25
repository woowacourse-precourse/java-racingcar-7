package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> winnerList;

    public Winner() {
        this.winnerList = new ArrayList<>();
    }

    public List<Car> getWinner() {
        return winnerList;
    }

    public void printWinner() {
        System.out.print("최종 우승자 : ");
        for (Car car : winnerList) {
            System.out.print(car.getName());
            if (winnerList.getLast() != car) {
                System.out.print(", ");
            }
        }
    }
}
