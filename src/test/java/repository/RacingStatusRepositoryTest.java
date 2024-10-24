package repository;

import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingStatusRepositoryTest {

    @DisplayName("name 중복검사 후 중복된 값이 있으면 true를 리턴한다.")
    @Test
    void isDuplicateName(){
    //given
        Repository repository = new RacingStatusRepository(new HashMap<>());
        repository.save("lala",12L);
        repository.save("dodo",12L);
        repository.save("dada",12L);

    //when
        Boolean duplicateName = repository.isDuplicateName("dada");
        //then
        Assertions.assertThat(duplicateName).isTrue();
    }

    @DisplayName("repository에 데이터를 저장한다.")
    @Test
    void save(){
        //given
        Repository repository = new RacingStatusRepository(new HashMap<>());
        //when
        repository.save("lala",12L);
        repository.save("dodo",13L);
        repository.save("dada",14L);

        //then
        Assertions.assertThat(repository.find("lala")).isEqualTo(12L);
    }



    @DisplayName("repository에서 우승자 명단을 찾는다.")
    @Test
    void findWinner(){

    }

}