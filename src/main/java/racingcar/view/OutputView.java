package racingcar.view;

import racingcar.model.Cars;

public class OutputView {
    public void printResultNotice(){
        printWhiteSpace();
        System.out.println("실행 결과");
    }
    public void printOneRoundResult(String carsDistance) {
        System.out.println(carsDistance);
        printWhiteSpace();
    }

    public void printWinner(Cars cars) {
        System.out.println("최종 우승자 : " + cars.getWinner());
    }

    private void printWhiteSpace(){
        System.out.println();
    }
}
