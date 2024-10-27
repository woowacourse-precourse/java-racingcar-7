package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표 기준으로 구분)");
        String names = Console.readLine();

        StringTokenizer tokenizer = new StringTokenizer(names, ",");
        List<Car> cars = new ArrayList<>();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attempts = Console.readLine();

        while (tokenizer.hasMoreTokens()) {
            String name = tokenizer.nextToken().trim(); // 공백 제거
            cars.add(new Car(name));
        }

        RaceController raceController = new RaceController();
        System.out.println("실행 결과");
        raceController.runRace(Integer.parseInt(attempts), cars);
    }
}
