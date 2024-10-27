package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.GameOverDTO;
import racingcar.dto.GameStartDTO;
import racingcar.dto.carRoundResultDTO;
import racingcar.dto.roundResultDTO;

import java.util.List;

public class GameOverView {
    public void gameOver(GameOverDTO gameOverDTO) {
        System.out.println("실행 결과");

        List<roundResultDTO> roundResults = gameOverDTO.getRoundResults();
        List<String> winners = gameOverDTO.getWinners();

        for (roundResultDTO roundResult : roundResults) {
            List<carRoundResultDTO> carRoundResults = roundResult.getCarRoundResults();

            for (carRoundResultDTO carRoundResult : carRoundResults) {
                String carName = carRoundResult.getCarName();
                Integer currentCount = carRoundResult.getCurrentCount();
                System.out.println(carName + " : " + "-".repeat(currentCount));
            }
            System.out.println("");
        }

        System.out.println("최종 우승자 : "+String.join(", ", winners));
    }
}
