package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private final List<Car> carList = new ArrayList<>();
    private final List<String> winnerCarList = new ArrayList<>();
    private int maxScore = 0;

    public CarGroup(String[] carList) {
        for (String carName : carList) {
            validateCarName(carName);
            Car car = new Car(carName);
            this.carList.add(car);
        }
    }

    private void validateCarName(String carName){
        if(carName.length()==0){
            throw new IllegalArgumentException("자동차 이름의 길이는 0이 될 수 없습니다.");
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void go() {
        for (Car car : carList) {
            car.drive();
        }
    }

    public void calculateMaxScore() {
        for (Car car : carList) {
            int i = car.getScore();
            if (maxScore < i) {
                maxScore = i;
            }
        }
    }

    public List<String> getWinnerCarList(){
        for(Car car: carList){
            if(car.getScore()==maxScore){
                winnerCarList.add(car.getName());
            }
        }
        return winnerCarList;
    }
}
