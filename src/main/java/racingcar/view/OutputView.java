package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;

import java.util.List;

import static racingcar.view.PrintMessages.*;

public class OutputView {

    public void printInputCarNamesMessage() {
        System.out.println(SET_CAR_NAME_MESSAGE);
    }

    public void printInputTryCountMessage() {
        System.out.println(SET_TRY_COUNT_MESSAGE);
    }

    public void printRacingResultMessage() {
        System.out.println(CURRENT_RESULT);
    }

    public void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            String carName = car.getName();
            String hyphenPoint = replacePointToHyphen(car.getPoint());

            System.out.println(carName + " : " + hyphenPoint);
        }
        System.out.println();
    }

    public void printFinalWinner(Winner winner) {
        List<Car> winners = winner.getWinners();

        System.out.print(FINAL_WINNER);
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private String replacePointToHyphen(int point) {
        String hyphenPoint = "";
        for (int i = 0; i < point; i++) {
            hyphenPoint += "-";
        }
        return hyphenPoint;
    }
}
