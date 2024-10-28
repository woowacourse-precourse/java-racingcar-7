package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarCollectionTest {

    CarCollection carCollection;

    @BeforeEach
    void setUp() {
        Engine engine = new RandomEngine();
        carCollection = CarCollection.of(
                List.of(
                        Car.of("pobi", engine),
                        Car.of("crong", engine),
                        Car.of("honux", engine)
                )
        );
    }

    @DisplayName("정적 팩터리 메서드 of는 List<Car>를 받아 Car의 일급 컬렉션을 생성한다.")
    @Test
    void of() {
        Engine engine = new RandomEngine();
        Car car1 = Car.of("pobi", engine);
        Car car2 = Car.of("crong", engine);
        Car car3 = Car.of("honux", engine);
        carCollection = CarCollection.of(List.of(car1, car2, car3));
        assertEquals(3, carCollection.getCars().size());
    }

    @DisplayName("Car 컬렉션의 getter는 UnmodifiableList를 반환한다.")
    @Test
    void getCars() {
        assertThrowsExactly(UnsupportedOperationException.class, () -> carCollection.getCars().removeFirst());
    }

}