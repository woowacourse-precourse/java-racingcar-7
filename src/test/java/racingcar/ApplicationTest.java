package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;
import racingcar.Service.CarService;
import racingcar.Service.GameService;
import racingcar.View.InputView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    CarService carService = new CarService();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 자동차_이름_분리_테스트(){
        GameService gameService=new GameService();
        String carNames="pobi,woni,jun";
        ArrayList<Car> carList=gameService.Separate_Carnames(carNames);
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getCarName()).isEqualTo("pobi");
        assertThat(carList.get(1).getCarName()).isEqualTo("woni");
        assertThat(carList.get(2).getCarName()).isEqualTo("jun");
    }
    @Test
    void 실행횟수_음수_처리_에러_테스트(){
        String Count="-1";
        ByteArrayInputStream Countin=new ByteArrayInputStream(Count.getBytes());
        System.setIn(Countin);
        assertThrows(IllegalArgumentException.class,()->{
            InputView.Game_count();
        });
    }
    @Test
    void 자동차_전진_테스트(){
        ArrayList<Car> cars=new ArrayList<>();
        Car car1=new Car("pobi");
        Car car2=new Car("woni");
        cars.add(car1);
        cars.add(car2);
        CarService car=new CarService();
        int testValueMove=4;
        int testValueNoMove=3;
        if(car.is_Move(testValueMove)){
            car1.setPosition();
        }
        if(car.is_Move(testValueNoMove)){
            car2.setPosition();
        }
        assertEquals("-",car1.getPosition());
        assertEquals("",car2.getPosition());
    }
    @Test
    void 자동차_이름_5자_초과_테스트(){
        String CarName="woniwoni";
        ByteArrayInputStream CarNamein=new ByteArrayInputStream(CarName.getBytes());
        System.setIn(CarNamein);
        assertThrows(IllegalArgumentException.class,()->{
            InputView.Car_names();
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
