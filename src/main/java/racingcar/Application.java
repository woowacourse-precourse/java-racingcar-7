package racingcar;

import camp.nextstep.edu.missionutils.Console;
import common.BeanFactory;
import common.RacingCarBeanFactory;
import controller.RacingController;
import input.InputData;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO : inputView 안에서 inputData 받아야 함.

        String name = Console.readLine();
        String count = Console.readLine();
        InputData inputData = new InputData(name, count);
        BeanFactory beanFactory = new RacingCarBeanFactory();
        RacingController racingController = new RacingController(beanFactory,inputData);
        racingController.racingStart();
    }
}
