package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.Collection;
import java.util.stream.Collectors;

public class OutputView {

    private static final String POINT = "-";

    public void printCarNameRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRaceCountRequest() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRacingStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRacingStatus(Collection<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(racingCar.getName())
                    .append(" : ")
                    .append(POINT.repeat(racingCar.getRaceScore()));
            System.out.println(stringBuilder);
        });
        System.out.println();
    }

    public void printWinner(Collection<RacingCar> racingCars) {
        String result = racingCars.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }

}
