package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car.Car;

import static org.assertj.core.api.Assertions.*;


class CarTest {


    @Test
    void createNamedCar_이름이10자초과_예외발생(){
        assertThatThrownBy(() -> {
                Car.createNamedCar("xxxxxxxxxxx");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최대 10자까지 가능 합니다.");
    }
    @Test
    void createNamedCar_이름이1자미만_예외발생(){
        assertThatThrownBy(() -> {
                Car.createNamedCar("");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최소 1자부터 가능 합니다.");
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
    void increaseDistanceBy_이동횟수1미만_예외발생(){
        // given
        Car car = Car.createNamedCar("car");

        // expect
        assertThatThrownBy(() -> car.increaseDistanceBy(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 거리는 최소 1스텝 이상 가능 합니다.");
    }
    @Test
    void increaseDistanceBy_이동횟수100초과_예외발생(){
        // given
        Car car = Car.createNamedCar("car");

        // expect
        assertThatThrownBy(() -> car.increaseDistanceBy(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 거리는 최대 100스텝 까지만 가능 합니다.");

    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,99,100})
    void increaseDistanceBy_이동횟수1포함100포함사이_예외발생안함(int count){
        // given
        Car car = Car.createNamedCar("car");

        // expect
        assertThatCode(() -> car.increaseDistanceBy(count))
                .doesNotThrowAnyException();
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,99,100})
    void increaseDistanceBy_이동횟수1포함100포함사이_위치증가(int count){
        // given
        Car car = Car.createNamedCar("test");

        // when
        Car movedCar = car.increaseDistanceBy(count);

        // then
       assertThat(movedCar.provideCurrentPosition()).isEqualTo(count);
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
    void provideCurrentPosition_초기생성_움직인거리0세팅() {
        // given
        String name = "test";

        // when
        Car car = Car.createNamedCar(name);

        // then
        assertThat(car.provideCurrentPosition()).isEqualTo(0);
    }
    @Test
    void provideCurrentPosition_이동한후_현위치반환함(){
        // given
        String name = "test";
        final int stepCount = 10;

        // when
        Car car = Car.createNamedCar(name);
        Car movedCar = car.increaseDistanceBy(stepCount);

        // then
        assertThat(movedCar.provideCurrentPosition()).isEqualTo(stepCount);
    }


}