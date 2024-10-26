package racingcar.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class CarNameExtractor {

    public LinkedHashMap<String, Integer> setGameEntry(String carName) {
        return initGameEntry(carName);
    }

    private LinkedHashMap<String, Integer> initGameEntry(String carName) {
        LinkedHashMap<String, Integer> gameEntry = new LinkedHashMap<>();
        List<String> carNames = extractCarName(carName);

        for (String name : carNames) {
            gameEntry.put(name, 0);
        }
        return gameEntry;
    }

    private List<String> extractCarName(String carName) {
        return Arrays.asList(carName.split(","));
    }
}
