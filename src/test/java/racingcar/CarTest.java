package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class CarTest {

    private Car testCar;
    @BeforeEach
    public void setUp(){
        this.testCar = Car.createNamedCar("car");

    }


    @Test
    void createNamedCar_이름이10자초과_예외발생(){
        assertThatThrownBy(() -> {
                Car car = Car.createNamedCar("xxxxxxxxxxx");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최대 10자까지 가능합니다.");
    }
    @Test
    void createNamedCar_이름이1자미만_예외발생(){
        assertThatThrownBy(() -> {
            Car car = Car.createNamedCar("");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최소 1자부터 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","22","333","4444","55555","666666","7777777","88888888","!!!!!!!!!","ㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌ"})
    void createNamedCar_1부터10자사이_생성성공(String name){
        assertThatCode(() -> Car.createNamedCar(name))
                .doesNotThrowAnyException();;


    }
    //
    //
    //

    @Test
    void moveForwardPosition_이동횟수1미만_예외발생(){
        assertThatThrownBy(() -> testCar.moveForwardPosition(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 최소 1보 이상만 가능합니다.");
    }
    @Test
    void moveForwardPosition_이동횟수100초과_예외발생(){
        assertThatThrownBy(() -> testCar.moveForwardPosition(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 최대 100보까지 가능합니다.");

    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,99,100})
    void moveForwardPosition_이동횟수1포함100포함사이_예외발생안함(int count){
        assertThatCode(() -> testCar.moveForwardPosition(count))
                .doesNotThrowAnyException();
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,99,100})
    void moveForwardPosition_이동횟수1포함100포함사이_위치증가(int count){
        // given
        Car car = Car.createNamedCar("test");

        // when
        car.moveForwardPosition(count);

        // then
       assertThat(car.provideCurrentPosition()).isEqualTo(count);
    }

    //
    @Test
    void maintainCurrentPosition_위치유지_이전위치유지() {

    }
    //
    @Test
    void provideCarName_이름조회_이름반환() {
        // given
        String name = "test";
        Car car = Car.createNamedCar(name);

        // when
        String carName = car.provideCarName();

        // then
        Assertions.assertThat(carName).isEqualTo(name);


    }
    @Test
    void provideCurrentPosition_초기생성_0반환() {

    }
    //


}