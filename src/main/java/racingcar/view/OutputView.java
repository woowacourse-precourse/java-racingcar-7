package racingcar.view;

import racingcar.model.Cars;

public class OutputView {
    private static final String RESULT_NOTICE_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public void printResultNotice(){
        printWhiteSpace();
        System.out.println(RESULT_NOTICE_MESSAGE);
    }
    public void printOneRoundResult(String carsDistance) {
        System.out.println(carsDistance);
        printWhiteSpace();
    }

    public void printWinner(Cars cars) {
        System.out.println(FINAL_WINNER_MESSAGE + cars.getWinner());
    }

    private void printWhiteSpace(){
        System.out.println();
    }
}
