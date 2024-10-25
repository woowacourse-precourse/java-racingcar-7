package racingcar.model;

import java.util.List;

public class Winner {

    private final List<Car> cars;
    private List<String> winners;
    private int maxPosition = 0;

    public Winner(List<Car> cars){
        this.cars = cars;
        selectWinners();
    }

    private void selectWinners(){
        findMaxPosition();
        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winners.add(car.getName());
            }
        }
    }

    private void findMaxPosition() {
        for(Car car : cars){
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }
    }

    public List<String> getWinners(){
        return winners;
    }
}
