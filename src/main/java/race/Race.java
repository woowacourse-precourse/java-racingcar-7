package race;

import java.util.HashMap;
import java.util.Map;

public class Race {


    public String Racing(String carString, String attempts) {

        Map<String, Integer> cars = storeCars(carString);

        int attempt = attemptToInt(attempts);



    }

    private Map<String, Integer> storeCars(String input) {

        Map<String, Integer> cars = new HashMap<>();

        String[] tokens = input.split(",");

        for(String token : tokens) {

            CheckException.checkNameOfCar(token);
            cars.put(token, 0);
        }

        return cars;
    }

    public int attemptToInt(String input) {

        int attempt = Integer.parseInt(input);

        CheckException.checkAttempt(attempt);

        return attempt;
    }
}
