package racingcar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarListTest {

    @Test
    public void testAddValidCar() {
        CarList carList = new CarList();
        carList.add("Racer");
        assertEquals(1, carList.getCars().size());
    }

    @Test
    public void testAddCarWithNullName() {
        CarList carList = new CarList();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            carList.add(null);
        });
        assertEquals("자동차의 이름을 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    public void testAddCarWithEmptyName() {
        CarList carList = new CarList();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            carList.add("");
        });
        assertEquals("자동차의 이름을 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    public void testAddCarWithLongName() {
        CarList carList = new CarList();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            carList.add("LongCarName");
        });
        assertEquals("자동차의 이름은 5글자를 넘을 수 없습니다.", exception.getMessage());
    }

    @Test
    public void testGetCarsReturnsUnmodifiableList() {
        CarList carList = new CarList();
        carList.add("Racer");
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            carList.getCars().add(new Car("NewCar"));
        });
        assertNotNull(exception);
    }
}
