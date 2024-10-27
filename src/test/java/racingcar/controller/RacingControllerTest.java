package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class RacingControllerTest {

    RacingController racingController = new RacingController();

    @Test
    @DisplayName("자동차_리스트_생성_테스트")
    void makeCarListTest() {
        // given
        String names = "testA,testB,testC";
        // when
        List<Car> carList = racingController.makeCarList(names);
        // then
        assertThat(carList).extracting("name").containsSequence("testA", "testB", "testC");
    }

    @Test
    @DisplayName("레이스_반복_테스트")
    void raceStartTest() {
        // given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("testA"));
        carList.add(new Car("testB"));
        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        racingController.raceStart(carList, 3);
        // then
        assertThat(out.toString()).contains("testA : ", "testB : ");
    }

    @Test
    @DisplayName("이름_5자_이하_테스트")
    void checkNameConditionTest() {
        racingController.checkNameCondition("short");

        assertThatThrownBy(() -> racingController.checkNameCondition("week2freecourse"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("반복횟수_0_or_양수")
    void checkNumberConditionTest() {
        racingController.checkNumberCondition("0");
        racingController.checkNumberCondition("5");

        assertThatThrownBy(() -> racingController.checkNumberCondition("-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}