package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private String[] cars;
    private Integer number;
    private List<Car> Cars = new ArrayList<>();

    public RacingCar(String str, Integer number) {
        this.cars = str.split(",");
        this.number = number;
    }

    private void checkLength() {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. (" + cars[i] + ")");
            }
        }
    }

    private void createCars() {
        for (String car : cars) {
            Cars.add(new Car(car));
        }
    }

    private void showCars() {
        for (Car car : Cars) {
            car.show();
        }
    }

    private void moveCars() {
        for (Car car : Cars) {
            car.randomMove();
        }
    }

    private void finalWinner() {
        String result = "";
        int count = 0;
        for (Car car : Cars) {
            if (car.getMoveCount() > count) {
                result = car.getCarName();
                count = car.getMoveCount();
            } else if (car.getMoveCount() == count) {
                result = result + ", " + car.getCarName();
            }
        }
        System.out.println("최종 우승자 : " + result);
    }

    public void run() {
        checkLength();
        createCars();
        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            moveCars();
            showCars();
            System.out.println(" ");
        }
        finalWinner();
    }
}
