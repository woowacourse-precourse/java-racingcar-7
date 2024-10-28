package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OutputViewTest extends NsTest {

    @Test
    void 차_이동_내역_출력_테스트() {
        // 출력 캡처
        runWithCustomOutput(() -> {
            List<Car> cars = List.of(
                    createAndMoveCar("pobi", 4),
                    createAndMoveCar("jun", 2)
            );
            OutputView.printCarMove(cars); // OutputView 메서드 직접 호출
        });

        assertThat(output()).contains("pobi : ----\njun : --");
    }

    @Test
    void 우승자_출력_테스트() {
        // 출력 캡처
        runWithCustomOutput(() -> {
            List<Car> cars = List.of(
                    createAndMoveCar("pobi", 4),
                    createAndMoveCar("jun", 2)
            );
            OutputView.printFinalWinners(cars); // OutputView 메서드 직접 호출
        });

        assertThat(output()).contains("최종 우승자 : pobi");
    }

    private Car createAndMoveCar(String name, int moveCount) {
        Car car = new Car(name);
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
        return car;
    }

    // NsTest의 runMain을 사용하지 않고, 커스텀 실행 메서드 정의
    private void runWithCustomOutput(Runnable customMethod) {
        try {
            customMethod.run();
        } finally {
            Console.close(); // 필요시 Console 관련 자원 해제
        }
    }

    @Override
    public void runMain() {
        // 이 테스트에서는 runMain이 필요하지 않음
    }
}
