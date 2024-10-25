package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readCarNames(){
        // String 배열을 List의 형태로 반환
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public int readAttempts(){
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
