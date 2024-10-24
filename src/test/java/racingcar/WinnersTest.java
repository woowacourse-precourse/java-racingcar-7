package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    @Test
    void 단일_우승자를_제대로_찾는지_테스트() {
        //1.Given(준비): 어떤 상황을 준비해야 하는가? - 자동차, 자동차의 위치
        //작성하기 까다로운 이유는 position이 private이기 때문일까?
        //getposition하고 새로운 변수에 담고 새 변수 값을 조작하여 비교하면 되지 않을까?
        //음 그럴거면 그냥 새 int 변수생성하고 0 1 지정하는거랑 다를게 없는데?
        //포지션을 조작하는 방법은 move메서드로 이동시키는 방법과(지금은 매개변수로 수를 받는데, 나중에 내부로
        //옮길수도있다. 그러면 따로 해결해야함. 인터넷을 보니 이렇게 private 인스턴스 변수를 건드릴때는
        //생성자를 오버로딩해서 해결하면 된다고한다. 생성자를 더 만드는 것은 언제나 장려된다고 한다.
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 2));
        cars.add(new Car("woni", 1));
        cars.add(new Car("jun", 0));
        //2.When(실행): 어떤 동작을 실행하는가? - 위치를 비교 후 우승자or공동우승자를 반환하는 메서드를 실행
        //즉 List cars를 받아서 List winners를 반환하면 된다.
        List<Car> winners = Winners.findWinner(cars);
        //3.Then(검증): 기대하는 결과는 무엇인가? - 자동차들의 위치를 비교하고 우승자를 결정
        //이 경우 단일 우승자이므로 pobi만 반환되어야한다.
        //contains는 내부적으로 equals로 동작한다.
        assertThat(winners).contains(new Car("pobi", 2));
        //winners는 list이므로 contains로 확인한다.
    }
}
