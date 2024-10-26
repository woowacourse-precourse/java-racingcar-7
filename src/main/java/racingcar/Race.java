package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();
    OutputView outputView = new OutputView();
    private int round;

    public Race(String [] names, int round) {
        addCars(names);
        this.round = round;
    }

    public void raceCars(){
        System.out.println("실행 결과");
        while (round > 0) {
            for (Car car : cars) {
                car.move();
                outputView.printStep(car.getName(), car.getLocation());
            }
            System.out.println();
            round --;
        }
    }

    public void awardWinner(){
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            if(car.getLocation() == getMaxLocation() ){
                names.add(car.getName());
            }
        }
        outputView.printWinner(names);
    }

    private int getMaxLocation() {
        int max = 0;
        for (Car car : cars) {
            if (car.getLocation() > max) {
                max = car.getLocation();
            }
        }
        return max;
    }




    private void addCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }
}
