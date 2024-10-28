package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 플레이어 이름, 이동횟수 n를 입력받고 List에 저장, for문을 통해 n번 3번클래스를 실행
        // sum값을 따로 저장하여 출력시엔 sum만큼 "-"를 출력, 우승자 뽑을 땐 가장 큰 sum값 출력
        String name="";
        int movements=0;
        List<String> names = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        name=Console.readLine();
        names = Arrays.asList(name.split("\\s*,\\s*"));

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            movements = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 숫자 입력입니다. 다시 입력해주세요.");
        }
    }
}
