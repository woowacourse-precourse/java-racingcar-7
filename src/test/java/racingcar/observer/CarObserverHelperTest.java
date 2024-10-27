package racingcar.observer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.input.InputHandler;
import racingcar.output.OutputHandler;
import racingcar.util.RandomValueGenerator;

import static org.junit.jupiter.api.Assertions.*;

class CarObserverHelperTest {

    public static final String CAR_NAME = "jjj";

    @Nested
    @DisplayName("addObserverToCar 메서드 테스트")
    class AddObserverToCarTest {

        @Test
        @DisplayName("올바른 매개변수를 제공했을 때, 예외가 발생하지 않는다.")
        void addObserverToCar_ValidParameters() {
            // given
            Car car = new Car(CAR_NAME);
            OutputHandler outputHandler = new OutputHandler();
            Class<CarMovePrinter> observerClass = CarMovePrinter.class;

            // when & then
            assertDoesNotThrow(() -> CarObserverHelper.addObserverToCar(car, observerClass, outputHandler),
                    "올바른 매개변수를 사용한 경우 예외가 발생하지 않아야 합니다.");
        }

        @Test
        @DisplayName("잘못된 매개변수를 제공했을 때, IllegalStateException이 발생한다.")
        void addObserverToCar_InvalidParameters1() {
            // given
            Car car = new Car(CAR_NAME);
            InputHandler inputHandler = new InputHandler(new OutputHandler()); // observer에 대한 잘못된 의존성
            Class<CarMovePrinter> observerClass = CarMovePrinter.class;

            // when & then
            assertThrows(IllegalStateException.class,
                    () -> CarObserverHelper.addObserverToCar(car, observerClass, inputHandler),
                    "잘못된 매개변수로 인해 IllegalStateException이 발생해야 합니다.");
        }

        @Test
        @DisplayName("잘못된 매개변수를 제공했을 때, IllegalStateException이 발생한다.")
        void addObserverToCar_InvalidParameters2() {
            // given
            Car car = new Car(CAR_NAME);
            RandomValueGenerator randomValueGenerator = new RandomValueGenerator(); // observer에 대한 잘못된 의존성
            Class<CarMovePrinter> observerClass = CarMovePrinter.class;

            // when & then
            assertThrows(IllegalStateException.class,
                    () -> CarObserverHelper.addObserverToCar(car, observerClass, randomValueGenerator),
                    "잘못된 매개변수로 인해 IllegalStateException이 발생해야 합니다.");
        }

        @Test
        @DisplayName("올바른 매개변수와 함께 잘못된 매개변수를 제공했을 때, IllegalStateException이 발생한다.")
        void addObserverToCar_InvalidParameters3() {
            // given
            Car car = new Car(CAR_NAME);
            OutputHandler outputHandler = new OutputHandler();
            InputHandler inputHandler = new InputHandler(outputHandler); // observer에 대한 잘못된 의존성
            Class<CarMovePrinter> observerClass = CarMovePrinter.class;

            // when & then
            assertThrows(IllegalStateException.class,
                    () -> CarObserverHelper.addObserverToCar(car, observerClass, outputHandler, inputHandler),
                    "잘못된 매개변수로 인해 IllegalStateException이 발생해야 합니다.");
        }

        @Test
        @DisplayName("null을 매개변수로 제공했을 때, IllegalArgumentException이 발생한다.")
        void addObserverToCar_NullParameters() {
            // given
            Car car = new Car(CAR_NAME);
            Class<CarMovePrinter> observerClass = CarMovePrinter.class;

            // when & then
            assertThrows(IllegalArgumentException.class,
                    () -> CarObserverHelper.addObserverToCar(car, observerClass, (Object) null),
                    "null 매개변수로 인해 IllegalArgumentException이 발생해야 합니다.");
        }
    }

}