package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private InputHandler inputHandler = new InputHandler();

    public void run() {
        String[] carNames = inputHandler.getCarNames();
        int tryCount = inputHandler.getTryCount();

        List<Car> carList = createCars(carNames);

        System.out.println();
        System.out.println("실행 결과");

        playRounds(tryCount,carList);
        printWinner(carList);
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private void playRounds(int tryCount, List<Car> carList) {
        for(int i=0; i<tryCount; i++) {
            for (Car car : carList) {
                car.move();
                car.printCount();
                System.out.println();
            }
            System.out.println();
        }
    }

    private void printWinner(List<Car> carList) {
        int max=0;
        for(Car car : carList) {
            if(car.count > max) {
                max = car.count;
            }
        }

        String winnerString = "";
        for(Car car : carList) {
            if(car.count == max) {
                winnerString += car.name + ", ";
            }
        }
        winnerString = winnerString.substring(0, winnerString.length() - 2);
        System.out.println("최종 우승자 : " + winnerString);
    }
}
