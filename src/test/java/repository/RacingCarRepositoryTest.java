package repository;

import java.util.HashMap;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.repository.RacingCarRepository;
import racingcar.domain.Car;

class RacingCarRepositoryTest {


    @DisplayName("repository에 데이터를 저장한다.")
    @Test
    void save(){
        //given
        RacingCarRepository repository = new RacingCarRepository(new HashMap<>());
        //when
        repository.save("lala",new Car("lala",12L));
        repository.save("dodo",new Car("dodo",13L));
        repository.save("dada",new Car("dada",14L));

        //then
        Assertions.assertThat(repository.find("lala").getMoveForwardCount()).isEqualTo(12L);
    }

    @DisplayName("repository에서 우승자 명단을 찾는다.")
    @Test
    void findWinner(){
            // TODO : 반복되는 것은 BeforEach쓰자
        //given
        RacingCarRepository repository = new RacingCarRepository(new HashMap<>());
        repository.save("lala",new Car("lala",12L));
        repository.save("dodo",new Car("dodo",13L));
        repository.save("dada",new Car("dada",14L));
        //when
        List<String> winner = repository.findWinner();

        //then
        Assertions.assertThat(winner.get(0)).isEqualTo("dada");
    }
    @DisplayName("repository에서 우승자는 여러명일 수 있다.")
    @Test
    void findWinners(){
        //given
        RacingCarRepository repository = new RacingCarRepository(new HashMap<>());
        repository.save("lala",new Car("lala",12L));
        repository.save("dodo",new Car("dodo",13L));
        repository.save("dada",new Car("dada",14L));
        repository.save("caca",new Car("caca",14L));
        repository.save("soso",new Car("soso",14L));
        //when
        List<String> winner = repository.findWinner();

        //then
        Assertions.assertThat(winner).hasSize(3);
    }

}