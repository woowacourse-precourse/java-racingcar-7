package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.CarCountService;
import racingcar.service.CarGameService;
import racingcar.service.CarNameService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CarControllerTest {
    final CarNameService carNameService = new CarNameService();
    final CarCountService carCountService = new CarCountService();
    final CarGameService carGameService = new CarGameService();

    @Test
    @DisplayName("기능이 최종적으로 잘 작동하는 지 확인한다. ")
    public void controllerTest() {
        List<Car> carNames = carNameService.getNamesFromString("aaa,bbb");
        int tryCount = carCountService.getTryCountFromString("3");

        Set<String> answer = new HashSet<>();
        answer.add("aaa");
        answer.add("bbb");
        answer.add("aaa, bbb");

        String result = carGameService.playGames(carNames, tryCount);
        System.out.println(result);
        assert answer.contains(result);
    }
}