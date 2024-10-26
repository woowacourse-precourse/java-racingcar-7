# Junit5 Parameterized Test

-------

## 1. 첫 번째 예제

--------
~~~
@ParameterizedTest
@ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // 6개의 정수
void isOdd_ShouldReturnTrueForOddNumbers(int number) {
    assertTrue(Numbers.isOdd(number));
}
~~~
* 해당 테스트 메서드는 총 6번 실행됩니다. 
* 각 실행시 ValueSource 의 값을 매개 변수로 받습니다.

## 2. 인수 소스

### 2.1 간단한 값

---
~~~
@ParameterizedTest
@ValueSource(strings = {"", "  "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
~~~
* ```@ValueSource``` 어노테이션으로 리터럴 값 배열을 테스트 메서드에 전달할 수 있습니다.

### 2.2 빈 값

--------
~~~
@ParameterizedTest
@NullSource
void isBlank_ShouldReturnTrueForNullInputs(String input) {
    assertTrue(Strings.isBlank(input));
}

@ParameterizedTest
@EmptySource
void isBlank_ShouldReturnTrueForEmptyStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
~~~
* JUnit 5.4부터 ```@NullSource```로 단일 null 값을, ``@EmptySource로`` 단일 빈 값을 전달할 수 있습니다.


~~~
@ParameterizedTest
@NullAndEmptySource
void isBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
~~~
* ```@NullAndEmptySource```로 null 및 빈 값을 모두 전달할 수도 있습니다.


### 2.3 Enum

-------
~~~
@ParameterizedTest
@EnumSource(Month.class)
void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
    int monthNumber = month.getValue();
    assertTrue(monthNumber >= 1 && monthNumber <= 12);
}
~~~
* 열거형 값을 사용할 때 @EnumSource 어노테이션을 사용할 수 있습니다.

~~~
@ParameterizedTest
@EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
void someMonths_Are30DaysLong(Month month) {
    final boolean isALeapYear = false;
    assertEquals(30, month.length(isALeapYear));
}
~~~
* 특정 값을 필터링 할 수도 있습니다.


### 2.4 CSV

-------
~~~
@ParameterizedTest
@CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
    String actualValue = input.toUpperCase();
    assertEquals(expected, actualValue);
}
~~~
* CSV 형식의 여러 값들을 전달하려면 ```@CsvSource```를 사용할 수 있습니다.

~~~
@ParameterizedTest
@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(
  String input, String expected) {
    String actualValue = input.toUpperCase();
    assertEquals(expected, actualValue);
}
~~~
* ``@CsvFileSource``를 사용하여 실제 CSV 파일을 읽을 수 있습니다.

### 2.5 메서드

------
~~~
@ParameterizedTest
@MethodSource("provideStringsForIsBlank")
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
    assertEquals(expected, Strings.isBlank(input));
}

private static Stream<Arguments> provideStringsForIsBlank() {
    return Stream.of(
      Arguments.of(null, true),
      Arguments.of("", true),
      Arguments.of("  ", true),
      Arguments.of("not blank", false)
    );
}
~~~
* ``@MethodSource``를 사용하여 복잡한 인수를 전달할 수 있습니다.


## 3. 또 다른 기능들

### 3.1 필드

------
~~~
static List<String> cities = Arrays.asList("Madrid", "Rome", "Paris", "London");

@ParameterizedTest
@FieldSource("cities")
void isBlank_ShouldReturnFalseWhenTheArgHasAtLeastOneCharacter(String arg) {
    assertFalse(Strings.isBlank(arg));
}
~~~
* JUnit 5.11부터 ```@FieldSource```로 필드를 사용해 매개변수를 전달할 수 있습니다.

-----
Ref) https://www.baeldung.com/parameterized-tests-junit-5
