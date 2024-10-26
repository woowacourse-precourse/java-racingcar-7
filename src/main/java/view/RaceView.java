package view;

import java.util.Map;

public class RaceView {

    public static void view(Map<String, Integer> map) {
        for (String car : map.keySet()) {
            System.out.println(car + " : " + "-".repeat(map.get(car)));
        }
    }
}
