//package racingcar;
//
//
//import java.util.List;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.*;
//
//class RacingcarTest {
//
//    @Test
//    void 스트링을_리스트로() {
//        Assertions.assertThat(Racingcar.readNamesInput("pobi,gill")).isEqualTo(List.of("pobi", "gill"));
//    }
//
//    @Test
//    void 이동횟수_받기() {
//
//        Assertions.assertThat(Racingcar.readNumInput(5)).isEqualTo(5);
//    }
//    @Test
//    void 랜덤숫자_받기() {
//        Assertions.assertThat(Racingcar.getRandomnum()).isBetween(0, 9);
//    }
//    @Test
//    void 전진() {
//        Assertions.assertThat(Racingcar.goCar("pobi", 4)).isEqualTo("pobi : -");
//    }
//    @Test
//    void 전진_실패() {
//        Assertions.assertThat(Racingcar.goCar("pobi", 3)).isEqualTo("no");
//    }
//}