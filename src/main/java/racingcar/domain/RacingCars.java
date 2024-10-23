package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private static final int CAR_LIST_MAX_SIZE = 10;

    private final List<Car> carList;
    public RacingCars(String readLine) {
        List<Car> tmpList = new ArrayList<>();
        String[] nameArray = readLine.split(",");
        for (String name : nameArray) {
            Car car = new Car(name);
            tmpList.add(car);
        }
        validationListSize(tmpList);
        this.carList = tmpList;
    }

    private void validationListSize(List<Car> tmpList) {
        if (tmpList.size() > CAR_LIST_MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차의 수는 " + CAR_LIST_MAX_SIZE +"이하만 가능합니다.");
        }
    }

    public void move() {
        for(Car car : carList) {
            car.randomMove();
        }
    }

    public String getStates() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Car car : carList) {
            stringBuilder.append(car.getState());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getWinners() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> winnerList = getWinnerList();
        for (String winner : winnerList) {
            stringBuilder.append(winner);
        }
        return stringBuilder.toString();
    }

    private List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        int maxPostion = getMaxPostion();
        for(Car car : carList) {
            if(car.getPostion() == maxPostion) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private int getMaxPostion() {
        int max = -1;
        for(Car car : carList) {
            int postion = car.getPostion();
            if(postion > max){
                max = postion;
            }
        }
        return max;
    }
}
