package racingcar;

import java.util.List;

public class Application {

        public static void main(String[] args) {
                CarNameInput carInput = new CarNameInput();
                AttemptInput attemptInput = new AttemptInput();

                List<String> carNames = carInput.getCarNames();
                int attempts = attemptInput.getAttempts();

                RacingGame racingGame = new RacingGame(carNames, attempts);
                racingGame.startRace();

                List<String> winners = determineWinners(racingGame);
                displayWinners(winners);
        }

        private static List<String> determineWinners(RacingGame racingGame) {
                WinnerDetermination winnerDetermination = new WinnerDetermination();
                return winnerDetermination.determineWinners(racingGame.getCarScores());
        }

        private static void displayWinners(List<String> winners) {
                System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
}
