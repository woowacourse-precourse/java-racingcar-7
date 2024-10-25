package racingcar;

import java.util.List;

public class RacingController {
    public static void run(){   // 모든 함수로 조립해 통합 컨트롤러 생성
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carsName = InputHandler.InputCarsName();
        Validator.validateCarNames(carsName);

        Racingcar[] racingcars = RacingGame.createRacingcars(carsName);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int racingRound = InputHandler.InputRacingRound();
        System.out.println();

        System.out.println("실행 결과");
        for (int i = 0; i < racingRound; i++) {
            RacingGame.checkMove(racingcars);
            OutputHandler.runOutput(racingcars);
            System.out.println();
        }

        List<Racingcar> winner = RacingGame.findWinner(racingcars);
        OutputHandler.winnerOuput(winner);
    }
}
