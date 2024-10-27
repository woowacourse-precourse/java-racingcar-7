package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 쉼표를_기준으로_입력을_잘라_이름_개수만큼_자동차를_만든다() {
        Cars cars = getCars();
        assertEquals(3, cars.getCars().size());
    }

    @Test
    void 쉼표를_기준으로_자른_이름이_5글자_보다_클_경우() {
        String input = "daesun,woni,jun";
        assertThrows(IllegalArgumentException.class, () -> Car.getInstance(input));
    }

    @Test
    @DisplayName("랜덥값은 4이상일 때 전진한다.")
    void 랜덤값들에_따라_자동차들이_움직일수있다(){
        List<Integer> randomNumbers = List.of(5, 6, 7);
        Cars cars = getCars();
        cars.moveAll(randomNumbers);
        assertEquals(1, cars.getCars().get(0).getDistance());
        assertEquals(1, cars.getCars().get(1).getDistance());
        assertEquals(1, cars.getCars().get(2).getDistance());
    }

    @Test
    void 랜덥값들의_개수와_자동차들의_개수가_다르면_예외_발생(){
        List<Integer> randomNumbers = List.of(5, 6);
        assertThrows(IllegalArgumentException.class, () -> getCars().moveAll(randomNumbers));
    }

    private Cars getCars() {
        String input = "pobi,woni,jun";
        return Cars.getInstance(input);
    }

}