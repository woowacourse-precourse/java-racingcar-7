package racingcar;

import static racingcar.CarRaceException.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        // 정수로 변환 불가능한 경우 예외 처리
        int moveAttempts = validateIntegerConversion(Console.readLine());

        List<String> winner = CarRace.start(carNames, moveAttempts);
        CarRace.printFinalWinners(winner);
    }
}
