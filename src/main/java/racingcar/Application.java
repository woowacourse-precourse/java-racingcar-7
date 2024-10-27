package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarNameList = Console.readLine();
        List<Car> CarList = Cars(CarNameList);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int Attempt = ReadAttempt();

        System.out.println(CarList);
        System.out.println(Attempt);

    }

    public static List<Car> Cars(String CarNameList) {
        String[] CarNames = CarNameList.split(",");
        List<Car> CarList = new ArrayList<>();
        for (String CarName : CarNames) {
            CarList.add(new Car(CarName.trim()));
        }
        return CarList;
    };

    // 시도 횟수 Int 형식으로 입력 (그 외 오류 처리)
    public static int ReadAttempt(){
        try {
            return Integer.parseInt(Console.readLine());
        }   catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자이어야 합니다.");
        }
    }
}
