package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_객체가_올바르게_생성되는지_테스트() {
        //객체들을 생성하여 다루는 car를 테스트하며 model -> car 클래스로 넘어왔다.
        //객체 생성 테스트는 1-2-3 순으로 작성하게 된다.
        //1.Given(준비): 어떤 상황을 준비해야 하는가? 자동차 이름을 준비한다.
        String carName = "pobi";
        //2.When(실행): 어떤 동작을 실행하는가? 차의 이름을 new Car(name)로 받아 생성한다.
        Car car = new Car(carName);
        //given에 String타입 이름 리스트를 사용해 Car 리스트에 객체를 생성하며 담아낸다.
        //3.Then(검증): 기대하는 결과는 무엇인가? 각 자동차가 올바르게 생성되는지 확인한다.
        assertThat(car.getCarName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);

        //테스트를 작성하며 결정한 것은 차 객체 생성시 어떤 매개변수를 받을건지, 어떤 인스턴스 변수를 세팅할지
        //결정하였다. name과 distance는 이후 로직 작동에 필요한 인스턴스 변수이다.
    }

    @Test
    void 랜덤_값에_따라_올바르게_전진하는지_테스트() {
        Car car = new Car("pobi");
        //테스트를 위해 랜덤넘버를 고정한다.
        int randomNumber = 4;
        //랜덤값을 매개변수로 받는 메서드로 숫자에 따라 이동과 멈춤을 결정한다.
        car.goForward(randomNumber);
        //조건을 만족할 경우 distance가 증가하는지 확인한다.
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_값에_따라_올바르게_멈춰있는지_테스트() {
        Car car = new Car("pobi");
        //테스트를 위해 랜덤넘버를 고정한다.
        int randomNumber = 3;
        //멈춰있는지 테스트는 시작값과 메서드 시행 이후의 값이 같은지 테스트한다.
        assertThat(car.getPosition()).isEqualTo(0);

        //랜덤값을 매개변수로 받는 메서드로 숫자에 따라 이동과 멈춤을 결정한다.
        car.goForward(randomNumber);
        //조건을 만족할 경우 distance가 증가하는지 확인한다.
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
