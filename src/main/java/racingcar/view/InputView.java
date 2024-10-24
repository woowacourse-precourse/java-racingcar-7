package racingcar.view;

import racingcar.controller.InputController;
import java.util.List;

public class InputView {
    //InputController inputController = new InputController();
    // private static final InputController inputController = new InputController();

    public static List<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames= InputController.getName();
        return carNames;
    }

    public static Integer getTryNum(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNum= InputController.getNum();
        return tryNum;
    }
}

