package controller;

import common.BeanFactory;
import common.RacingCarBeanFactory;
import input.OriginalInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import policy.RacingCarPolicyImpl;
import vehicle.Car;

class RacingControllerTest {


    @DisplayName("빈팩토리에서 서비스를 생성해 주입해준다.")
    @Test
    void provideServiceFromBeanFactory() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        OriginalInput originalInput = new OriginalInput("dada,ming,mong", "5");
        //when
        RacingController racingController = new RacingController(beanFactory, originalInput);
        //then
        org.assertj.core.api.Assertions.assertThat(racingController).isNotNull();
    }


    @DisplayName("inputData 값의 공백을 제거한다.")
    @Test
    void replaceBlankInput() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        OriginalInput originalInput = new OriginalInput("dada,ming,mong", "5");
        RacingController racingController = new RacingController(beanFactory, originalInput);

        //when
        OriginalInput replaceBlankInputData = racingController.replaceBlankInput(originalInput.name(), originalInput.count());
        //then
        Assertions.assertThat(replaceBlankInputData.name()).isEqualTo("dada,ming,mong");
        Assertions.assertThat(replaceBlankInputData.count()).isEqualTo("5");
    }

    @DisplayName("inputData 값이 공백이면 에러를 반환한다.")
    @Test
    void isEmptyInput() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        OriginalInput originalInput = new OriginalInput(" ", " ");
        RacingController racingController = new RacingController(beanFactory, originalInput);
        OriginalInput replaceBlankInputData = racingController.replaceBlankInput(originalInput.name(),originalInput.count());

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        racingController.isEmptyInput(replaceBlankInputData.name(), replaceBlankInputData.count()))
                .isInstanceOf(IllegalArgumentException.class);
    }




    @DisplayName("test")
    @Test
    void test() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        OriginalInput originalInput = new OriginalInput(" ", " ");
        RacingController racingController = new RacingController(beanFactory, originalInput);
        OriginalInput replaceBlankInputData = racingController.replaceBlankInput(originalInput.name(),originalInput.count());

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("dodo", new RacingCarPolicyImpl(), Long.parseLong("2")));
        carList.add(new Car("lala", new RacingCarPolicyImpl(), Long.parseLong("3")));
        carList.add(new Car("dada", new RacingCarPolicyImpl(), Long.parseLong("1")));

        System.out.println();

        carList.sort(Comparator.comparing(Car::getMoveForwardCount).reversed());

        System.out.println(Arrays.toString(carList.toArray()));
        //when

        //then

    }

}