package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.RacingCar;

public class Application {
    public static void main(String[] args) {
        // 입력한 자동차 이름에 공백이 포함되거나 빈 문자열이면 예외 처리
        // 이름이 5글자를 넘어가면 예외 처리
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<RacingCar> racers = new ArrayList<>();
        String[] racerNames = Console.readLine().split(",");
        for (String name : racerNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            racers.add(new RacingCar(name.strip()));
        }

        // 숫자가 아닌 문자 입력 시 예외 발생
        System.out.println("시도할 횟수는 몇 회인가요?");
        int totalMove = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");
        for (int i = 0; i < totalMove; i++) {
            for (RacingCar racer : racers) {
                racer.moveOrStop();
                System.out.printf("%s : %s\n", racer.getName(), racer.getMovingState());
            }
            System.out.println();
        }
        Collections.sort(racers);

        int maxMoveCount = racers.getFirst().getMoveCount();
        List<String> winner = racers.stream()
                .takeWhile(racer -> racer.getMoveCount() == maxMoveCount)
                .map(RacingCar::getName).toList();
        System.out.printf("최종 우승자 : %s\n", String.join(", ", winner));
    }
}
