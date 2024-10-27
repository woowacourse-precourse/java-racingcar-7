package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = sc.nextLine();

        if(!validateCarName(input)) {
            throw new IllegalArgumentException("이름은 쉼표로 구분되어야 하며, 1~5자 사이여야 합니다.");
        }

        return parseCarName(input);
    }

    public static int moveCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = sc.nextLine();

        try {
            int moveCount = Integer.parseInt(input);
            System.out.println(moveCount);
            if (moveCount < 1) {
                throw new IllegalArgumentException("이동 횟수는 자연수이며, 21억 이하여야 합니다.");
            }

            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 자연수이며, 21억 이하여야 합니다.");
        }
    }

    private static boolean validateCarName(String input) {
        List<String> names = parseCarName(input);
        return input.contains(",") && names.stream().allMatch(InputView::isValidName) && input.matches("[a-zA-Z0-9,]+");
    }

    private static boolean isValidName(String name) {
        return !name.isEmpty() && name.length() <= 5 && !name.isBlank();
    }

    private static List<String> parseCarName(String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
