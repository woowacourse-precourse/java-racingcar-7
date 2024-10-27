package racingcar;

import java.util.HashMap;

public class Race {

    Random rand = new Random();
    Output output = new Output();

    protected void race(HashMap<String, Integer> car, Integer number) {
        for (String key : car.keySet()) {
            for (int i = 0; i < number; i++) {
                if (rand.random() >= 4) {
                    car.put(key, car.get(key) + number);
                }
            }
        }
    }

    protected String winner(HashMap<String, Integer> car, Integer number) {
        String result = "";
        return result;
    }
}
