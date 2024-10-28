package racingcar.study;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomTest {

    @Test
    @DisplayName("리스트 내 숫자가 1개 일 때, 1개의 원소만 반환한다.")
    void pickNumberInHasOneElementList() {
        List<Integer> numbers = List.of(1);
        int number = Randoms.pickNumberInList(numbers);
        assertThat(number).isEqualTo(1);
    }

    @Test
    @DisplayName("리스트 내 숫자만 반환한다.")
    void pickOnlyWithinList() {
        List<Integer> numbers = List.of(1, 2, 3);
        for (int i = 0; i < 10; i++) {
            int number = Randoms.pickNumberInList(numbers);
            assertThat(numbers.contains(number)).isTrue();
        }
    }

    @Test
    @DisplayName("숫자가 섞인다")
    void shuffle() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> shuffle = Randoms.shuffle(numbers);
        assertThat(shuffle).containsAll(numbers);
    }

    @Test
    @DisplayName("범위내 숫자를 pick한다.")
    void pickNumberInRange() {
        int number = Randoms.pickNumberInRange(0, 9);
        assertThat(number).isLessThan(10);
    }

    @Test
    @DisplayName("범위 내 다른 숫자를 pick 한다.")
    void pickUniqueNumbersInRange() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(0, 9, 10);
        Set<Integer> notDuplicates = new HashSet<>(numbers);
        assertThat(notDuplicates).hasSize(numbers.size());
    }

}
