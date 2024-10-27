# AssertJ를 활용한 예외검증

* Java 8을 사용하면 AssertJ와 람다 표현식을 통해 예외 검증을 간단하게 할 수 있습니다.

--------

## 1. ``assertThatThrownBy()`` 사용하기

-------
~~~
assertThatThrownBy(() -> {
    List<String> list = Arrays.asList("String one", "String two");
    list.get(2);
}).isInstanceOf(IndexOutOfBoundsException.class)
  .hasMessageContaining("Index: 2, Size: 2");
~~~
* 리스트의 범위를 벗어난 항목에 접근할 때 IndexOutOfBoundsException이 발생하는지 확인할 수 있습니다.

~~~
.hasMessage("Index: %s, Size: %s", 2, 2)
.hasMessageStartingWith("Index: 2")
.hasMessageContaining("2")
.hasMessageEndingWith("Size: 2")
.hasMessageMatching("Index: \\d+, Size: \\d+")
.hasCauseInstanceOf(IOException.class)
.hasStackTraceContaining("java.io.IOException");
~~~
* 위와 같은 형식이 대체되어 들어갈 수 있습니다.


## 2. ``assertThatExceptionOfType`` 사용하기

-------
~~~
assertThatExceptionOfType(IndexOutOfBoundsException.class)
.isThrownBy(() -> {
// ...
}).hasMessageMatching("Index: \\d+, Size: \\d+");
~~~
* 처음에 예외를 설정하고 검증하는 방법입니다.


## 3. 자주 쓰이는 예외 유형 메서드

-------
~~~
assertThatIOException().isThrownBy(() -> {
    // ...
});
~~~
* 해당 형식이 가장 자주 쓰이는 메서드 형식입니다.

~~~
assertThatIllegalArgumentException()
assertThatIllegalStateException()
assertThatIOException()
assertThatNullPointerException()
~~~
* 해당 exception 으로 대체될 수 있습니다.

## 4. when - then 을 사용한 예외처리

------
~~~
// when
Throwable thrown = catchThrowable(() -> {
    // ...
});

// then
assertThat(thrown)
  .isInstanceOf(ArithmeticException.class)
  .hasMessageContaining("/ by zero");
~~~
* when / then 을 논리적으로 나누어 테스트를 진행할 수 있습니다.

## 5. 사용자가 직접 코드에서 예외처리 하는 법

-------

**CityNotFoundException**
~~~
public class CityNotFoundException extends RuntimeException {

    private String city;
    private String message;

    CityNotFoundException(String city, String message) {
        this.city = city;
        this.message = message;
    }

    // Getters

}
~~~
* 이렇게 직접 예외처리 부분을 지정할 수 있습니다.


**CityUtils**
~~~
public final class CityUtils {

    private static final List<String> CITIES = Arrays.asList("Tamassint", "London", "Madrid", "New york");

    public static String search(String searchedCity) {
        return CITIES.stream()
          .filter(searchedCity::equals)
          .findFirst()
          .orElseThrow(() -> new CityNotFoundException(searchedCity, "The specified city is not found"));
    }

}
~~~

**Test**
~~~
@Test
public void whenUsingCatchThrowableOfType_thenAssertField() {
    String givenCity = "Paris";
    CityNotFoundException exception = catchThrowableOfType(() -> CityUtils.search(givenCity), CityNotFoundException.class);

    assertThat(exception.getCity()).isEqualTo(givenCity);
    assertThat(exception.getMessage()).isEqualTo("The specified city is not found");
}

혹은

@Test
public void whenUsingAssertThatThrownBy_thenAssertField() {
    String givenCity = "Geneva";
    assertThatThrownBy(() -> CityUtils.search(givenCity)).isInstanceOf(CityNotFoundException.class)
      .extracting("city")
      .isEqualTo(givenCity);
}
~~~



------
Ref) https://www.baeldung.com/assertj-exception-assertion
