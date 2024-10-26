package racingcar.util;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class EnhancedListTest {

    private EnhancedList<Integer> enhancedList;

    @Test
    void 최대값과_동일한_모든_요소를_리스트로_반환한다() {
        // given
        enhancedList = new EnhancedList<>(List.of(1, 5, 5, 3, 5, 2, 4));

        // when
        List<Integer> result = enhancedList.maxAll();

        // then
        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsOnly(5, 5, 5);
            softly.assertThat(result)
                    .hasSize(3);
            softly.assertThat(result)
                    .allMatch(num -> num == 5);
        });
    }

    @Test
    void 단일_최대값만_있는_경우_하나의_요소를_가진_리스트를_반환한다() {
        // given
        List<Integer> singleMaxList = List.of(1, 2, 3, 4, 5);
        enhancedList = new EnhancedList<>(singleMaxList);

        // when
        List<Integer> result = enhancedList.maxAll();

        // then
        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly(5);
            softly.assertThat(result)
                    .hasSize(1);
            softly.assertThat(result.getFirst())
                    .isEqualTo(5);
        });
    }

    @Test
    void 빈_리스트에_대해_예외를_발생시킨다() {
        // given
        enhancedList = new EnhancedList<Integer>(List.of());

        // when & then
        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> enhancedList.maxAll())
                    .isInstanceOf(NoSuchElementException.class);
        });
    }

    @Test
    void 리스트의_기본_작업들이_정상적으로_동작한다() {
        // given
        enhancedList = new EnhancedList<Integer>(new ArrayList<>());

        // when
        enhancedList.add(1);
        enhancedList.add(2);
        enhancedList.remove(Integer.valueOf(1));

        // then
        assertSoftly(softly -> {
            softly.assertThat(enhancedList)
                    .containsExactly(2);
            softly.assertThat(enhancedList)
                    .hasSize(1);
            softly.assertThat(enhancedList.contains(1))
                    .isFalse();
        });
    }

    @Test
    void 커스텀_객체에_대해_정상적으로_동작한다() {
        // given
        List<Person> people = List.of(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 30),
                new Person("David", 28)
        );
        EnhancedList<Person> enhancedPeopleList = new EnhancedList<>(people);

        // when
        List<Person> result = enhancedPeopleList.maxAll();

        // then
        assertSoftly(softly -> {
            softly.assertThat(result)
                    .hasSize(2);
            softly.assertThat(result)
                    .allMatch(person -> person.getAge() == 30);
            softly.assertThat(result)
                    .extracting("name")
                    .containsExactlyInAnyOrder("Bob", "Charlie");
        });
    }

    private static class Person implements Comparable<Person> {
        private final String name;
        private final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }
    }
}
