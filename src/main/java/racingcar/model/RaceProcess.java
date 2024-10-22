package racingcar.model;

import java.util.*;

public class RaceProcess {
    private final InputParser inputParser;
    private final RaceOrNot raceOrNot;

    public RaceProcess(InputParser inputParser, RaceOrNot raceOrNot) {
        this.inputParser = inputParser;
        this.raceOrNot = raceOrNot;
    }

    public List<String> racing(String input_cars, String input_nums) {
        // 일단 돌아가는 쓰레기
        List<String> cars = inputParser.parseCars(input_cars);
        int number = inputParser.parseNum(input_nums);

    }

}
