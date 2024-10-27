package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingGameInitializationRequest;

public class RacingCarGameView {
    public RacingGameInitializationRequest gameInit () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String participant = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String time = Console.readLine();

        return new RacingGameInitializationRequest(participant, time);
    }

    public void racingGameCurrentSituationPrint (String racingResult, String winnerParticipants) {
        System.out.println("실행결과");
        System.out.println(racingResult);

        System.out.println("최종 우승자 : " + winnerParticipants);
    }
}
