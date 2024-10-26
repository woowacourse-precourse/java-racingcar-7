package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Output {
    List<Car> carList = new ArrayList<>();

    public Output(List<Car> carList) {
        this.carList = carList;
    }

    public void printOutput() {
        int max = -1;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() > max) {
                max = carList.get(i).getPosition();
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() == max) {
                System.out.print(carList.get(i).getName());
                if (i != carList.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
