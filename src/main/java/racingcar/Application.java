package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<String> cars = getCars();

    }

    private static List<String> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> cars = new ArrayList<String>(Arrays.asList(input.split(",")));
        return cars;
    }
}