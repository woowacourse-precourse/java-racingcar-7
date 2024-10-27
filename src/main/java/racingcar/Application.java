package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void race(final String text) {
        String[] name = text.split(",");
        // 이름은 5자 이하만 가능
        final int numberOfCar = name.length;
        ArrayList<Integer> racingDistance = new ArrayList<>(numberOfCar);

        for (int i = 0; i < numberOfCar; i++) {
            racingDistance.add(0);
        }
    }
}
