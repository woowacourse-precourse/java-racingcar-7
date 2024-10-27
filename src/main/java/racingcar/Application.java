package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] Inputs = RacingCar.readInputs();
        String input_names = Inputs[0];
        String input_times = Inputs[1];
        RacingCar.checkInputException(input_names, input_times);
        Map<String, Object> processed_inputs = RacingCar.processInputs(input_names, input_times);
        List<String> names = (List<String>)processed_inputs.get("names");
        List<Integer> distances = (List<Integer>)processed_inputs.get("distances");
        Integer times = (Integer)processed_inputs.get("times");
        RacingCar.printOutputs(names,distances,times);
    }
}
