package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(" 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars_name = getCarsName();

    }

    public static List<String> getCarsName() {
        String input = Console.readLine();
        return List.of(input.split(","));
    }
}


