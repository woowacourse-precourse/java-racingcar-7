package race;

import car.Car;
import java.util.List;

public class RacingProgress {
    private final List<Car> carList;
    private Integer roundCount;

    public RacingProgress(List<Car> carList, Integer roundCounter){
        this.carList = carList;
        this.roundCount = roundCounter;
    }

    public void raceStart(){
        System.out.println("실행 결과");
        while(roundCount-- > 0){
            moveCars();
            printCars();
        }
    }

    private void moveCars(){
        for(Car car : carList){
            car.move();
        }
    }

    private void printCars(){
        for(Car car : carList){
            System.out.println(car);
        }
        System.out.println();
    }

}
