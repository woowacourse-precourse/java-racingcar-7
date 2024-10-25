package racingcar;

import java.util.List;

public class Winner {

    public String printWinner(List<Car> carList){
        String winner = "";
        int maxPosition = getMasPosition(carList);
        for (Car car : carList) {
            if(car.getPosition() == maxPosition){
                winner += car.getCarName() + ", ";
            }
        }
        return winner.replaceAll(", $", "");
    }

    public int getMasPosition(List<Car> carList){
        int maxPosition = 0;
        for (Car car : carList) {
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
