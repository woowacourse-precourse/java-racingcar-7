package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    private final List<String> winnerList;
    private final List<Car> carList;

    public Race() {
        winnerList = new ArrayList<>();
        carList = new ArrayList<>();
    }

    private boolean checkCarName(String carName) {
        if (carName.isEmpty()) {
            return false;
        }

        if (carName.length() > 5) {
            return false;
        }

        return true;
    }

    public void setCarListByName(String s) {
        String[] carNames = s.split(",");

        for (String carName : carNames) {
            if (checkCarName(carName)) {
                carList.add(new Car(carName, 0));
            } else {
                throw new IllegalArgumentException("Invalid car name");
            }
        }
    }

    public void StartRace(int round) {
        for (int i = 0; i < round; i++) {
            for (Car car : carList) {
                car.moveForward();
                car.printPosition();
            }
            System.out.println();
        }

        int bestPosition = 0;

        for (Car car : carList) {
            if (car.getCurrentPosition() > bestPosition) {
                winnerList.clear();
                bestPosition = car.getCurrentPosition();
                winnerList.add(car.getName());
            } else if (car.getCurrentPosition() == bestPosition) {
                winnerList.add(car.getName());
            }
        }
    }

    public void printWinner(){
           System.out.print("최종 우승자 : ");

           System.out.println(String.join(", ", winnerList));
    }
}
