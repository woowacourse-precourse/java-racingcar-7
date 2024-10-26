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
        int count = 0;

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() > max) {
                max = carList.get(i).getPosition();
                count++;
            } else if (carList.get(i).getPosition() == max) {
                count++;
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() == max) {
                System.out.print(carList.get(i).getName());

                if (--count != 0) {
                    System.out.print(", ");
                }
            }
        }
    }
}
