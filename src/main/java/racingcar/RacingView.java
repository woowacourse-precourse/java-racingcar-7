package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingView {

    public void raceReadyView(RacingDto dto) {

        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String carNameList = Console.readLine();
        System.out.println(carNameList);

        System.out.println("시도할 횟수");
        String raceMovement = Console.readLine();
        System.out.println(raceMovement);

        dto.setRace(carNameList, raceMovement);
    }

    public void raceGoView(RacingDto dto) {
        System.out.println("실행 결과");
        for (int i = 0; i < dto.getRaceMovement(); i++) {
            for (Car player : dto.goRace()) {
                System.out.println(player.getCarName() + " : " + player.getDistance());
            }
            System.out.println();
        }

    }

    public void winnerView(RacingDto dto) {
        System.out.println("최종 우승자 : " + dto.getWinner());
    }
}
