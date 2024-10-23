package racingcar;

import common.BeanFactory;
import common.RacingCarBeanFactory;
import controller.RacingController;
import view.RacingCarInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO : inputView 안에서 inputData 받아야 함.
        BeanFactory beanFactory = new RacingCarBeanFactory();
        RacingController racingController = new RacingController(beanFactory,new RacingCarInputView().receiveInputData());
        String run = racingController.run();

    }
}
