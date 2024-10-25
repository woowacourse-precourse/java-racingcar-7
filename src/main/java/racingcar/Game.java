package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Game {
    private List<Car> cars = new ArrayList<>();
    private final InputVIew inputVIew = new InputVIew();

    public void startGame() {
        String[] names = inputVIew.getInput();
        int count = inputVIew.getCount();
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
        while (count > 0) {
            for (Car car : cars) {
                car.move();
            }

            for (Car car : cars) {
                System.out.print(car.getName() + " : ");
                for (int i = 0; i < car.getLocation(); i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
            count --;
        }
    }

    private void awardWinner(){
        int max = 0;
        for (Car car : cars) {
            if (car.getLocation() > max) {
                max = car.getLocation();
            }
        }
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Car car : cars) {
            if(car.getLocation() ==max ){
                stringJoiner.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + stringJoiner.toString());
    }

}



