package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    public List<String> readCarNames(){
        // String 배열을 List의 형태로 반환
        String input = Console.readLine();
        validateInput(input);
        return Arrays.asList(input.split(","));
    }

    public int readAttempts(){
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateInput(String input) {
        //정규식을 활용하여 입력값을 확인
        String regex = "^\\w{1,5}(,\\w{1,5})*$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 1-5글자의 이름을 쉼표(,)로 구분하여 입력해주세요.");
        }
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백이 포함되어 있습니다.");
        }
    }
}
