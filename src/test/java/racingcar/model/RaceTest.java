package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    void 자동차_이름이_주어졌을_때() {
        Race race = new Race("sisu,java", "3");
        assertThat(race.getRacingCars().stream().map(Car::getName).toList()).containsExactly("sisu", "java");

    }

    @Test
    void 자동차_이름이_5자_초과일_때() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("longNameTest,test,java,sisu", "3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("java jigi,test,java,sisu", "3");
        });
    }

    @Test
    void 이름이_없는_입력값이_주어질_때() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("", "3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(",sisu", "3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu,", "3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu,,java", "3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu,,", "3");
        });
    }

    @Test
    void 중복되는_이름이_있을_때() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu,sisu", "3");
        });
    }

    @Test
    void 정수가_아닌_값이_round_인자로_주어졌을_때() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu", "I'm not an integer");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu", "0.999999999999999999999");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu", "3.1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu", "3e");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu", "3!");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu", "100000000000000000000000000000000000");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu", "");
        });
    }

    @Test
    void 양수가_아닌_값이_round_인자로_주어졌을_때() {
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu", "-1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race("sisu", "0");
        });

    }
//    @Test
//    void 우승자_확인() {
//        Race race = new Race("해건,수미,영재");
////        assertThat(race.get)
//    }
}
