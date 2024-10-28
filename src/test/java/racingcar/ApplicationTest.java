package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream standardIn = System.in;

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

    // 기능 1에 대한 테스트 코드
    @Test
    void createCarTest(){
        String testInput = "pobi,won,juddy,ki";
        List<Application.Car> resultList = Application.createCarList(testInput);

        assertEquals(4, resultList.size());
        assertEquals("pobi", resultList.get(0).getName());
        assertEquals("won", resultList.get(1).getName());
        assertEquals("juddy", resultList.get(2).getName());
        assertEquals("ki", resultList.get(3).getName());
    }
    // 기능 2, 3, 4에 대한 테스트 코드
    @Test
    void driveTest(){
        int testMoveLength = 5;
        int testDontMove = 2;
        List<Application.Car> carList = new ArrayList<Application.Car>();
        carList.add( new Application.Car( "pobi" ) );
        carList.add( new Application.Car( "woni" ) );
        carList.add( new Application.Car( "jun" ) );

        carList.get(0).drive( testMoveLength );
        carList.get(1).drive( testDontMove );
        carList.get(2).drive( testMoveLength );

        assertEquals( testMoveLength, carList.get(0).getDistance() );
        assertEquals( 0, carList.get(1).getDistance() );
        assertEquals( testMoveLength, carList.get(2).getDistance() );
    }
    
    // 기능 5에 대한 테스트 코드
    @Test
    void chooseWinnerTest(){
        List<Application.Car> cars = new ArrayList<>();
        Application.Car car1 = new Application.Car("pobi");
        car1.setDistance(5);
        Application.Car car2 = new Application.Car("woni");
        car2.setDistance(3);
        Application.Car car3 = new Application.Car("jun");
        car3.setDistance(4);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        List<Application.Car> winners = Application.chooseWinner(cars);

        assertEquals(1, winners.size());
        assertEquals("pobi", winners.get(0).getName());
        assertEquals(5, winners.get(0).getDistance());
    }
    
    // 기능 6에 대한 테스트 코드
    void randomDriveTest(){
        List<Application.Car> carList = new ArrayList<Application.Car>();
        carList.add( new Application.Car( "pobi" ) );
        carList.add( new Application.Car( "woni" ) );
        carList.add( new Application.Car( "jun" ) );

        int first = Application.tryRoll();
        int second = Application.tryRoll();
        int third = Application.tryRoll();

        int expectFirst = 0;
        int expectSecond = 0;
        int expectThird = 0;

        carList.get(0).drive( first );
        carList.get(1).drive( second );
        carList.get(2).drive( third );

        if( first >= 4 ) expectFirst = first;
        if( second >= 4 ) expectSecond = first;
        if( third >= 4 ) expectThird = first;

        assertEquals( expectFirst, carList.get(0).getDistance() );
        assertEquals( expectSecond, carList.get(1).getDistance() );
        assertEquals( expectThird, carList.get(2).getDistance() );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
