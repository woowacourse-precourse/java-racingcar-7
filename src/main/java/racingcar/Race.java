package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Race {
    private final List<Car> cars = new ArrayList<>();
    private final int moves;

    public Race(String carNames, int moves) {
        this.moves = moves;
        initializeCars(carNames);
    }

    private void initializeCars(String carNames) {
        String[] names = carNames.split(",");
        Map<String, Integer> nameCount = new HashMap<>();
        for (String name : names) {
            addCarWithUniqueName(name.trim(), nameCount);
        }
    }

    private void addCarWithUniqueName(String name, Map<String, Integer> nameCount) {
        nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        String uniqueName = nameCount.get(name) > 1 ? name + nameCount.get(name) : name;
        cars.add(new Car(uniqueName));
    }

    public void startRace() {
        for (int i = 0; i < moves; i++) {
            playRound();
            System.out.println();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getName() + " : " + car.displayPosition());
        }
    }

}
