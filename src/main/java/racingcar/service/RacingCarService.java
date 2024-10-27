package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.util.SeparatorParser;
import racingcar.validator.InputValidator;

public class RacingCarService {

    private int attempt;
    private LinkedHashMap<String, Integer> cars = new LinkedHashMap<>();
    private final SeparatorParser separatorParser;
    private final InputValidator inputValidator;

    public RacingCarService(SeparatorParser separatorParser, InputValidator inputValidator) {
        this.separatorParser = separatorParser;
        this.inputValidator = inputValidator;
    }

    public void racing() {
        System.out.println("실행 결과");
        for (int i = 0; i < attempt; i++) {
            moveCars();
            printIntermediateResults();
        }
    }

    private void moveCars() {
        for (String carName : cars.keySet()) {
            moveCar(carName);
        }
    }

    private void moveCar(String carName) {
        if (getPickedNumber() >= 4) {
            cars.put(carName, cars.get(carName) + 1);
        }
    }

    private int getPickedNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printIntermediateResults() {
        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            String result = convertToDashString(entry.getValue());
            printCarRacingResult(entry.getKey(), result);
        }
        System.out.println();
    }

    private String convertToDashString(Integer runAttempt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runAttempt; i++) {
            sb.append("-");
        }
        return String.valueOf(sb);
    }

    private void printCarRacingResult(String carName, String result) {
        System.out.println(carName + " : " + result);
    }


    public void initRacingCars(String inputCarNames) {
        if (inputValidator.isInputEmpty(inputCarNames)) {
            throw new IllegalArgumentException("경주할 자동차 이름을 입력해주세요.");
        }

        String[] carNames = separatorParser.parseCarNames(inputCarNames);

        if (!inputValidator.validCarNameLength(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 최대 5글자 입니다.");
        }

        for (int i = 0; i < carNames.length; i++) {
            cars.put(carNames[i], 0);
        }
    }

    public void initRacingAttempt(String inputRacingAttempt) {
        this.attempt = inputValidator.getValidatedRacingAttempt(inputRacingAttempt);
    }

    private List<String> findWinners() {
        int maxValue = cars.values().stream().max(Integer::compareTo).orElse(0);

        return cars.entrySet().stream()
                .filter(e -> e.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public String getWinnersMessage() {
        List<String> maxValueKeys = findWinners();

        return formatWinnersMessage(maxValueKeys);
    }

    private static String formatWinnersMessage(List<String> maxValueKeys) {
        if (maxValueKeys.size() == 1) {
            return "최종 우승자 : " + maxValueKeys.get(0);
        } else if (maxValueKeys.size() > 1) {
            return "최종 우승자 : " + String.join(", ", maxValueKeys);
        }

        throw new IllegalArgumentException("우승자를 찾을 수 없습니다.");
    }

}
