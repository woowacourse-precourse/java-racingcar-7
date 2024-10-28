package racingcar.model;

import racingcar.view.outputView.ProgressOutputView;

import java.util.ArrayList;
import java.util.List;

public class WinnerSelector {
    private final List<Car> carList;
    private final List<Car> winners;
    private final Integer moveCount;
    private final ProgressOutputView progressOutputView;

    public WinnerSelector(List<Car> carList, Integer moveCount){
        this.carList = carList;
        this.moveCount = moveCount;
        this.winners = new ArrayList<>();
        this.progressOutputView = new ProgressOutputView(carList);
    }

    public void racing(){
        for(int i = 0; i < moveCount; i++){
            for(Car car: carList){
                car.moveForward();
            }
            progressOutputView.print();
        }
    }

    public void selectWinners(){
        Integer maxDistance = Integer.MIN_VALUE;

        for(Car car: carList){
            maxDistance = selectWinner(car, maxDistance);
        }
    }

    private Integer selectWinner(Car car, Integer maxDistance){
        if(car.getDistance() > maxDistance){
            winners.clear();
            winners.add(car);
        }
        else if(car.getDistance() == maxDistance){
            winners.add(car);
        }

        return Math.max(car.getDistance(), maxDistance);
    }

    public List<Car> getWinners() {
        return winners;
    }
}
