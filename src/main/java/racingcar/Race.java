package racingcar;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.Collections;
import java.util.Objects;

public class Race {

    Random rand = new Random();
    Output output = new Output();

    protected HashMap<String, Integer> race(HashMap<String, Integer> car, Integer number) {
        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            for (String key : car.keySet()) {
                if (rand.random() >= 4) {
                    car.put(key, car.get(key) + 1);
                }
            }
            output.processPrint(car);
        }
        return car;
    }


    protected HashMap<String, Integer> winner(HashMap<String, Integer> car) {

        Integer maxValue = Collections.max(car.values());

        for (String key : car.keySet()) {
            if (!Objects.equals(car.get(key), maxValue)) {
                car.remove(key);
            }
        }

        return car;

    }
}
