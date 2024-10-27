package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        //Todo 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = scanner.nextLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int moves = Integer.parseInt(scanner.nextLine());

        Racing racing = new Racing(validateCarNames(inputNames));
        racing.startRace(moves);
    }

    private static List<String> validateCarNames(String inputNames) {
        List<String> carNames = Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        if (carNames.isEmpty() || carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
        }

        return carNames;
    }
}
