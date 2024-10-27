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
        String input_names = "";
        String input_times = "";
        RacingCar.readInputs(input_names, input_times);
        RacingCar.checkInputException(input_names, input_times);
        RacingCar.processInputs(names, distances, times, input_names, input_times);
        RacingCar.printOutputs(names,distances,times);
    }
}
