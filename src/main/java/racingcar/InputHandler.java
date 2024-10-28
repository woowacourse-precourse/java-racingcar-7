package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static ArrayList<String> CarName = new ArrayList<String>();
    private static int racingCounter;

    public static void initInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        validateAndSetCarNames(Console.readLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        setRacingCounter(Console.readLine());
    }

    public static void validateAndSetCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] names = input.split(",");

        for (String name : names) {
            validateCarName(name);
        }

        CarName.clear();
        CarName.addAll(Arrays.asList(names));
    }

    private static void validateCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        if (name.contains(".")) {
            throw new IllegalArgumentException();
        }
    }

    public static void setRacingCounter(String input) {
        try {
            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }

            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException();
            }
            racingCounter = count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static ArrayList<String> getCarName() {
        return new ArrayList<>(CarName);
    }

    public static int getRacingCounter() {
        return racingCounter;
    }
}