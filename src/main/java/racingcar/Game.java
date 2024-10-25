package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Game {
    private List<Car> cars = new ArrayList<>();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startGame() {
        String[] names = inputView.getInput();
        int count = inputView.getCount();
        addCars(names);
        raceCars(count);
        awardWinner();
    }

    private void addCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void raceCars(int count){
        System.out.println("실행 결과");
        while (count > 0) {
            for (Car car : cars) {
                car.move();
                outputView.printStep(car.getName(), car.getLocation());
            }
            System.out.println();
            count --;
        }
    }

    private void awardWinner(){
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

}



