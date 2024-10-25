package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {}

    public static OutputView getInstance() {
        return instance;
    }

    public void printInterimResult(){
        //중간 결과 출력
    }

    public void printResult() {
        //최종 결과 출력
        System.out.print("최종 우승자 : ");
    }
}
