package racingcar;

import common.RacingCarBeanFactory;
import controller.RacingController;
import dto.RacingOutputDTO;
import policy.RacingCarPolicy;
import view.RacingCarInputView;
import view.RacingCarOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarBeanFactory beanFactory = new RacingCarBeanFactory();
        RacingController racingController = new RacingController(beanFactory,new RacingCarInputView().receiveInputData(new RacingCarPolicy()));
        RacingOutputDTO run = racingController.run();
        new RacingCarOutputView(run).printRacingResult();
    }
}
