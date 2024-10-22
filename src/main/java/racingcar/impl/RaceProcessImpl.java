package racingcar.impl;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racingcar.model.InputParser;
import racingcar.model.RaceOrNot;

public class RaceProcessImpl {
    private final InputParser inputParser;
    private final RaceOrNot raceOrNot;

    public RaceProcessImpl(InputParser inputParser, RaceOrNot raceOrNot) {
        this.inputParser = inputParser;
        this.raceOrNot = raceOrNot;
    }

    // 자동차 경주 전체 과정
    public List<String> racing(String input_cars, String input_nums) {
        // 일단 돌아가는 쓰레기
        List<String> cars = inputParser.parseCars(input_cars);
        int number = inputParser.parseNum(input_nums);
        HashMap<String, Integer> carRacingResult = initProcess(cars);

        for (int i = 0; i < number; i++) {
            carRacingResult = process(carRacingResult);
        }
        return findWinner(carRacingResult);
    }

    public HashMap<String, Integer> initProcess(List<String> cars) {
        HashMap<String, Integer> carRacingResult = new HashMap<>();
        for (String str: cars) {
            carRacingResult.put(str, 0);
        }
        return carRacingResult;
    }

    // 레이싱 과정 - 시도 횟수 1회에 따른 전체 자동차에 대한 goForward 시도 및 갱신
    public HashMap<String, Integer> process(HashMap<String, Integer> carRacingResult) {
        for (Entry<String, Integer> cr: carRacingResult.entrySet()) {
            if (raceOrNot.goForward()) {
                carRacingResult.replace(cr.getKey(), cr.getValue()+1);
            }
        }
        return carRacingResult;
    }

    public List<String> findWinner(HashMap<String, Integer> carRacingResult) {
        // Map에서 최대값 찾기
        int maxValue = Collections.max(carRacingResult.values());

        // 최대값을 가진 모든 키 찾기
        List<String> winner = carRacingResult.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return winner;
    }
}
