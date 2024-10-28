package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RegisterTest {

    @Test
    void 자동차_리스트_등록_리스트_길이_확인() {
        Register register = new Register();
        ArrayList<String> cars = new ArrayList<>(Arrays.asList("진용", "진용2", "진용3"));

        register.carListUp(cars);

        Assertions.assertThat(register.carList.size()).isEqualTo(3);
    }

    @Test
    void 자동차_리스트_등록_이름_초기화_확인() {
        Register register = new Register();
        ArrayList<String> cars = new ArrayList<>(Arrays.asList("진용", "진용2", "진용3"));

        register.carListUp(cars);

        Assertions.assertThat(register.carList)
                .extracting("name")
                .containsExactly("진용", "진용2", "진용3");
    }

    @Test
    void 자동차_리스트_등록_전진_횟수_초기화_확인() {
        Register register = new Register();
        ArrayList<String> cars = new ArrayList<>(Arrays.asList("진용", "진용2", "진용3"));

        register.carListUp(cars);

        Assertions.assertThat(register.carList)
                .extracting("distance")
                .containsExactly(0, 0, 0);
    }


    @Test
    void 자동차_이름_전진_횟수_확인() {
        Register register = new Register();
        register.carList.add(new Car("진용"));
        register.carList.add(new Car("진용1"));
        register.carList.add(new Car("진용2"));

        register.carList.get(0).distance = 1;
        register.carList.get(1).distance = 2;
        register.carList.get(2).distance = 3;

        HashMap<String, Integer> expectedMove = new HashMap<>();
        expectedMove.put("진용", 1);
        expectedMove.put("진용1", 2);
        expectedMove.put("진용2", 3);

        Assertions.assertThat(register.carsMoveCountList()).isEqualTo(expectedMove);
    }

    @Test
    void 우승자_조회() {
        Register register = new Register();
        register.carList.add(new Car("진용"));
        register.carList.add(new Car("hi"));
        register.carList.add(new Car("강감찬"));

        register.carList.get(0).distance = 3;
        register.carList.get(1).distance = 1;
        register.carList.get(2).distance = 3;

        ArrayList<String> expectedWinner = new ArrayList<>();
        expectedWinner.add("진용");
        expectedWinner.add("강감찬");

        Assertions.assertThat(register.racingWinner()).isEqualTo(expectedWinner);
    }

}