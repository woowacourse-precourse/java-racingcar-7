package racingcar;

import common.BeanFactory;
import common.RacingCarBeanFactory;
import controller.RacingController;
import view.RacingCarInputView;
import view.RacingCarOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BeanFactory beanFactory = new RacingCarBeanFactory();
        RacingController racingController = new RacingController(beanFactory,new RacingCarInputView().receiveInputData());
        new RacingCarOutputView(racingController.run()).printRacingResult();
    }
}
