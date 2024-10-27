package racingcar.domain.game;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarGroup;

class WinnerCalculatorTest {

    GameRule gameRule = new WootecoRule();
    WinnerCalculator winnerCalculator = new WinnerCalculator(gameRule);

    @Test
    public void 레이싱_게임의_우승자_목록을_반환한다() {
        //given
        CarGroup carGroup = new CarGroup(Arrays.asList(new Car("povi"), new Car("minu")));

        //when
        List<String> winnerNames = winnerCalculator.getWinnerNames(carGroup.getCarInfos());

        //then
        Assertions.assertThat(winnerNames).contains("povi", "minu");
    }


    @Test
    public void 레이싱_게임의_우승자_목록을_반환한다_우승자_한명일때() {
        //given
        Car car = new Car("povi");
        CarGroup carGroup = new CarGroup(Arrays.asList(car, new Car("minu")));

        //when
        car.accelerate();
        List<String> winnerNames = winnerCalculator.getWinnerNames(carGroup.getCarInfos());

        //then
        Assertions.assertThat(winnerNames).contains("povi");
    }

    @Test
    public void 게임의_참가자가_없으면_예외가_발생한다() {
        //given
        CarGroup carGroup = new CarGroup(List.of());

        //then when
        Assertions.assertThatThrownBy(() -> winnerCalculator.getWinnerNames(carGroup.getCarInfos()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}