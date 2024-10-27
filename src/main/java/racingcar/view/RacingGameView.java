package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGameView {

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public String inputRacingCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return readLine();
    }

    public void printRaceResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRaceProgress(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public void printRaceWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
