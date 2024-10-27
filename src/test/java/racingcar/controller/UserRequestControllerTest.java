package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRequestControllerTest {
    UserRequestController userRequestController;

    @BeforeEach
    void setUserRequestController(){
        userRequestController = new UserRequestController();
    }

    @Test
    void userInputDataTest(){
        //given
        String carNames = "k1,k2,k3";
        String repeat = "3";
        //when
        userRequestController.userInputData(carNames, repeat);
        //then


    }

    @Test
    void saveCarTest(){
        //given
        String carNames = "k1, k2,k3,k4";
        //when
        userRequestController.saveCar(carNames);
        List<String> carList = userRequestController.getCarList();
        List<Integer> distance = userRequestController.getDistanceList();
        //then
        assertThat(carList.size()).isEqualTo(4);
        assertThat(distance.size()).isEqualTo(4);

    }

}