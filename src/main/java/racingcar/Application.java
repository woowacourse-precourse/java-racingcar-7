package racingcar;

import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LinkedHashMap<String, StringBuffer> cars = InputHandler.getNames();
        int raceCount = InputHandler.getNumber();
        Race.startRace(cars, raceCount);
    }
}
