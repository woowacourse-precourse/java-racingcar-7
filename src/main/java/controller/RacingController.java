package controller;

import common.BeanFactory;
import input.InputData;
import service.RacingService;


/**
 * RacingController application에서 데이터를 받아와 뿌려주는 역할
 */
public class RacingController {

    private final BeanFactory beanFactory;
    private final RacingService racingService;
    private final InputData inputData;

    public RacingController(BeanFactory beanFactory, InputData inputData) {
        this.beanFactory = beanFactory;
        this.racingService = beanFactory.provideRacingService();
        this.inputData = inputData;
    }

    public void racingStart() {

    }

}
