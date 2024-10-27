package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Round> rounds = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private int count;

    public Race(String[] names, int count) {
        addCars(names);
        this.count = count;
    }

    public void raceCars() {
        while (count > 0) {
            Round round = new Round();
            for (Car car : cars) {
                car.move();
                round.addCarLocation(car.getName(),car.getLocation());
            }
            rounds.add(round);
            count--;
        }
    }

    //시행한 모든 라운드
    public List<Round> getRounds() {
        return rounds;
    }


    //우승자
    public List<String> getWinner() {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == getMaxLocation()) {
                names.add(car.getName());
            }
        }
        return names;
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
