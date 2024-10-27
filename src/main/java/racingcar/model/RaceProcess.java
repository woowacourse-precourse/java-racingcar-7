package racingcar.model;

import java.util.*;

public interface RaceProcess {
    List<String> readyCar(String input_cars);

    int readyNum(String input_nums);

    HashMap<String, Integer> initProcess(List<String> cars);

    HashMap<String, Integer> process(HashMap<String, Integer> carRacingResult);

    List<String> findWinner(HashMap<String, Integer> carRacingResult);
}
