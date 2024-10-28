package racingcar;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgementTest {


    private Judgement judgement;

    @BeforeEach
    void setUp() {
        judgement = new Judgement();
    }


    @Test
    @DisplayName("최고 직진 횟수를 가진 자동차를 우승자로 선택")
    void 최고_직진인_자동차가_우승자인지_확인() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("daae");
        Car car3 = new Car("woni");

        car1.movement();
        car1.movement();
        car2.movement();
        car3.movement();
        car3.movement();
        car3.movement();

        List<String> winners = judgement.getWinners(List.of(car1, car2, car3));
        Assertions.assertEquals(List.of("woni"), winners);

    }

    @Test
    @DisplayName("우승자가 여러명인경우 쉼표로 구분하여 반환")
    void 동시_우승자_쉼표로_구분_출력() {
        Car car1 = new Car("daae");
        Car car2 = new Car("pobi");

        car1.movement();
        car2.movement();

        List<String> winners = judgement.getWinners(List.of(car1, car2));

        Assertions.assertEquals(List.of("daae", "pobi"), winners);

    }


}
