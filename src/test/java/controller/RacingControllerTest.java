package controller;

import common.BeanFactory;
import common.RacingCarBeanFactory;
import input.InputData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingControllerTest {


    @DisplayName("빈팩토리에서 서비스를 생성해 주입해줄 수 있다.")
    @Test
    void provideServiceFromBeanFactory() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        InputData inputData = new InputData("dada,ming,mong", "5");
        //when
        RacingController racingController = new RacingController(beanFactory, inputData);
        //then
        org.assertj.core.api.Assertions.assertThat(racingController).isNotNull();
    }


    @DisplayName("인풋값을 검증 할 수 있다.")
    @Test
    void validateInput() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        InputData inputData = new InputData("dada,ming,mong", "5");
        //when
        RacingController racingController = new RacingController(beanFactory, inputData);
        //then

    }

}