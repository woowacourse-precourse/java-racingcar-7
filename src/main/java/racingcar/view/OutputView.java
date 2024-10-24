package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Winner;

import java.util.List;

public class OutputView {
    //OutputView 내부에 상수를 정의해서 사용하는 장점이 무엇인지, 메서드이름으로도 충분히 식별을 가능
    private final static String SET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String SET_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final static String CURRENT_RESULT = "실행 결과";
    private final static String FINAL_WINNER = "최종 우승자 : ";

    public void printInputCarNamesMessage() {
        System.out.println(SET_CAR_NAME_MESSAGE);
    }

    public void printInputTryCountMessage() {
        System.out.println(SET_TRY_COUNT_MESSAGE);
    }

    public void printCurrentResult(List<Car> cars) {
        System.out.println(CURRENT_RESULT);
        for (Car car : cars) { //
            String carName = car.getName();
            String hyphenPoint = replacePointToHyphen(car.getWinningPoint());

            System.out.println(carName + " : " + hyphenPoint);
        }
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
        //불필요한 반복이 수행되는 느낌
        //위닝포인트 자체를 "-"로 출력할 수 있으면?
        for (int i = 0; i < point; i++) {
            hyphenPoint += "-";
        }
        return hyphenPoint;
    }
}
