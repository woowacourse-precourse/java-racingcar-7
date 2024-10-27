package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> winnerList;

    public Race() {
        winnerList = new ArrayList<>();
    }

    public void start(List<Car> carList, int attemptCount) {
        racing(carList, attemptCount);

        findWinner(carList);

        showWinnerList();
    }

    public void racing(List<Car> carList, int attemptCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            moveCars(carList, attemptCount - i);
            System.out.println();
        }
    }

    public void moveCars(List<Car> carList, int remainingCount) {
        for (Car car : carList) {
            car.move(remainingCount);
        }
    }

    public void findWinner(List<Car> carList) {
        winnerList.add(carList.getFirst());
        for (int i = 1; i < carList.size(); i++) {
            addWinner(carList.get(i));
        }
    }

    public void addWinner(Car currentCar) {
        if (currentCar.getProgress() > winnerList.getFirst().getProgress()) {
            winnerList.clear();
            winnerList.add(currentCar);
        } else if (currentCar.getProgress() == winnerList.getFirst().getProgress()) {
            winnerList.add(currentCar);
        }
    }

    public void showWinnerList() {
        StringBuilder winnerNames = new StringBuilder();
        for (int i = 0; i < winnerList.size(); i++) {
            winnerNames.append(winnerList.get(i).getName());
            winnerNames.append(", ");
        }
        winnerNames.deleteCharAt(winnerNames.length() - 2);
        System.out.print("최종 우승자 : ");
        System.out.println(winnerNames);
    }
}
