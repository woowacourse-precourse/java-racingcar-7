package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        run();

    }

    private static void run() {

        inputCars();

    }

    private static void inputCars() {
        print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();

        List<String> names = getValidNames(carsInput);
        if (isValidInput(names)) {

        }

    }

    private static boolean isValidInput(List<String> names) {
        if (names.size() > 20) throw new IllegalArgumentException("자동차 이름은 20개 이하로 입력하세요.");

        for (String name : names) {
            if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력하세요.");
        }

        return true;
    }

    private static List<String> getValidNames(String namesInput) {
        List<String> names = new ArrayList<>();
        for (String name : namesInput.split(",")) {
            String compactName = name.trim();
            if (!compactName.isEmpty()) names.add(compactName);
        }

        return names;
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
