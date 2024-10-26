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
            print();
        }
    }

    private void moveCars() {
        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            int pickedNumber = Randoms.pickNumberInRange(0, 9);
            if (pickedNumber >= 4) {
                entry.setValue(entry.getValue() + 1);
            }
        }
    }

    private void print() {
        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            String result = convertToString(entry.getValue());
            System.out.println(entry.getKey() + " : " + result);
        }
        System.out.println();
    }

    private String convertToString(Integer runAttempt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runAttempt; i++) {
            sb.append("-");
        }
        return String.valueOf(sb);
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

        if (maxValueKeys.size() == 1) {
            return "최종 우승자 : " + maxValueKeys.get(0);
        } else if (maxValueKeys.size() > 1) {
            return "최종 우승자 : " + String.join(", ", maxValueKeys);
        }

        throw new IllegalArgumentException("우승자를 찾을 수 없습니다.");
    }

}
