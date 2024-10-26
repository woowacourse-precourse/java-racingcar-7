package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingController {
    private InputView inputView;
    private OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public static void validateCharacters(List<String> names) {
        final String englishRegex = "a-zA-Z";
        final String koreanRegex = "ㄱ-ㅎㅏ-ㅣ가-힣";

        if (!names.stream().allMatch(name -> name.matches("^[" + englishRegex + koreanRegex + "]*$"))) {
            throw new IllegalArgumentException("이름에 허용되지 않는 문자가 들어가 있습니다 (한국어+영어만 가능).");
        }
    }

    public static void validateLength(List<String> names) {
        final int MAX_NAME_LENGTH = 5;

        if (names.stream().anyMatch(name -> name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException("각 이름의 길이는 " + MAX_NAME_LENGTH + "자를 넘길 수 없습니다.");
        }

        if (names.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("빈 이름이 존재합니다.");
        }
    }



    public static void moveCars(LinkedHashMap<String, Integer> cars) {
        for (Entry<String, Integer> car : cars.entrySet()) {
            if (canMove()) {
                cars.put(car.getKey(), car.getValue() + 1);
            }
            System.out.println(car.getKey() + " : " + "-".repeat(car.getValue()));
        }
        System.out.println();
    }

    public static boolean canMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }



    public void run() {

        List<String> names = inputView.getCarNames();

        validateCharacters(names);
        validateLength(names);

        int totalMoves = inputView.getTotalRounds();

        System.out.println("실행 결과");

        LinkedHashMap<String,Integer> cars = new LinkedHashMap<>();

        for (String name: names) {
            cars.put(name, 0);
        }

        for (int indexMoves = 0; indexMoves < totalMoves; indexMoves++) {
            moveCars(cars);
        }

        outputView.printWinners(cars);
    }

}
