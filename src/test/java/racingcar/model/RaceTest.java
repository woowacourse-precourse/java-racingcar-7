package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceTest {

        /*
        객체의 값을 일일히 다 비교하는 방법을 모르겠어서 우선 나중에 하기로 함...
         */
//    @Test
//    void 자동차_이름이_주어졌을_때() {
//        Race race = new Race("해건,수미,영재");
//        List<Car> expectedResult = new ArrayList<>();
//        expectedResult.add(new Car("해건"));
//        expectedResult.add(new Car("수미"));
//        expectedResult.add(new Car("영재"));
//
//    }

    @Test
    void 자동차_이름이_5자_초과일_때() {
        assertThrows(IllegalArgumentException.class,
                () -> {
            Race race = new Race("OverFiveLength,test,수미,해건", "3");
        });
    }

//    @Test
//    void 우승자_확인() {
//        Race race = new Race("해건,수미,영재");
////        assertThat(race.get)
//    }
}
