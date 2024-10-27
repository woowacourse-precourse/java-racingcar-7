package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    // 자동차 이름 입력받기
    public static List<String> readNamesInput(){
        String nameInput = Console.readLine();
        List<String> names = Arrays.asList(nameInput.split(","));
        return names;
    }
    // 총 이동횟수 입력받기
    public static int readMoveNumInput(){
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // 예외 발생
        }
    }
}
