package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import racingcar.model.Car;
import racingcar.model.Winner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class OutputViewTest extends NsTest {

    OutputView outputView = new OutputView();

    @Override
    protected void runMain() {

    }

    @Test
    @DisplayName("현재 결과형식을 콘솔에 출력한다")
    void printCurrentResultAtConsole() {
        //given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        pobi.moveForward();
        pobi.moveForward();
        woni.moveForward();
        jun.moveForward();

        List<Car> cars = List.of(pobi, woni, jun);

        String expectPrint = "실행 결과\n"
                + pobi.getName() + " : --\n"
                + woni.getName() + " : -\n"
                + jun.getName() + " : -";

        //when
        outputView.printCurrentResult(cars);

        //then
        assertThat(expectPrint).isEqualTo(output());
    }

    @Test
    @DisplayName("최종 우승자형식을 콘솔에 출력한다")
    void printWinnerAtConsole() {
        //given
        List<Car> winners = List.of(new Car("pobi"));
        Winner winner = new Winner(winners);

        String expectPrint = "최종 우승자 : pobi";

        //when
        outputView.printFinalWinner(winner);

        //then
        assertThat(expectPrint).isEqualTo(output());
    }

    @Test
    @DisplayName("공동 우승시 \",\"로 우승자를 구분시 마지막 우승자 뒤에는 붙지 않는다")
    void printWinnersAtConsole() {
        //given
        List<Car> winners = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        Winner winner = new Winner(winners);

        String expectPrint = "최종 우승자 : pobi, woni, jun";

        //when
        outputView.printFinalWinner(winner);

        //then
        assertThat(expectPrint).isEqualTo(output());
    }
}