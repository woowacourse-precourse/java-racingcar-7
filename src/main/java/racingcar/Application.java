package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] names = {};
        int[] distances = {};
        Integer times = 0;
        RacingCar.readInputs(names,distances,times);
        RacingCar.printOutputs(names,distances,times);

    }
}
