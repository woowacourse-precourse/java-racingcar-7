package racingcar.model;

import java.util.HashMap;
import java.util.List;

public class SettingModel {

    public static HashMap<String, Integer> gameSetting(List<String> names) {
        HashMap<String, Integer> gameSet = new HashMap<>();
        for (String name : names) {
            gameSet.put(name, 0);
        }
        return gameSet;
    }

}
