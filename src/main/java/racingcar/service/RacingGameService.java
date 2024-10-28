package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validation.Inputvalidator;
import racingcar.view.OutputView;

import static racingcar.validation.Inputvalidator.validateCarNames;
import static racingcar.validation.Inputvalidator.validateTryNumber;

public class RacingGameService {
    public void processRacingCars(String racingCars, String tryNumber) {
        String[] carNames = racingCars.split(",");

        validateCarNames(racingCars);
        validateTryNumber(tryNumber);

        int attempts = Integer.parseInt(tryNumber);
        int[] goCounts = new int[carNames.length];

        for (int i = 0; i < attempts; i++) {
            for (int j = 0; j < carNames.length; j++) {
                if (goOrStop()) {
                    goCounts[j]++;
                }
            }
            OutputView.printRoundResults(carNames,goCounts);
        }

        String winners = determineWinners(carNames, goCounts);
        OutputView.printWinners(winners);

    }

    private boolean goOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    private String determineWinners(String[] carNames, int[] goCounts) {
        int maxGoCount = 0;
        StringBuilder winners = new StringBuilder();

        // 최대 전진 횟수를 찾고, 해당 횟수와 일치하는 자동차 이름을 우승자로 추가
        for (int goCount : goCounts) {
            if (goCount > maxGoCount) {
                maxGoCount = goCount;
            }
        }
        for (int i = 0; i < goCounts.length; i++) {
            if (goCounts[i] == maxGoCount) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(carNames[i]);
            }
        }
        return winners.toString();
    }
}
