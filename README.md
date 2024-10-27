# java-racingcar-precourse

## 구현할 기능 목록

- [x]  문자열 입력 받기
    - [x]  문자열 유효성 검사
        - [x]  아무것도 입력하지 않음 (`””`)
    - [x]  자동차를 쉼표(,)를 기준으로 구분하기
    - [x]  자동차 이름 유효성 검사
        - [x]  1글자 미만 자동차 이름 (`””`)
        - [x]  중복된 자동차 이름
        - [x]  5글자 초과
    - [x]  각각의 자동차 객체 생성
- [x]  시도할 횟수 입력 받기
    - [x]  시도할 횟수 유효성 검사
        - [x]  공백 입력
        - [x]  문자 입력
        - [x]  음수 입력
- [x]  무작위 값에 의한 각각의 자동차 전진 또는 정지
- [x]  차수별 실행 결과 출력
- [x]  우승자(가장 많이 전진한 자동차) 확인
- [x]  우승자 출력

---

## 스스로 판단한 부분

- 자동차 이름은 중복될 수 없다.
    - `John,Jane,Mike,John`
        - `IllegalArgumentException`
- 자동차 이름은 1글자 이상 이어야 한다.
    - ``
    - `Jonh,Jane,,Mike`
        - `IllegalArgumentException`

---

## 예외 처리

- 문자열 입력시 예외 처리
    - 아무것도 입력하지 않음(””)

        ```java
        input : 
        output : IllegalArgumentException - 자동차 이름을 입력해야 합니다.
        ```

- 자동차 이름 유효성 검사 예외 처리
    - 1글자 미만 자동차 이름

        ```java
        input : Jonh,Jane,,Mike
        output : IllegalArgumentException - 자동차 이름은 1글자 이상이어야 합니다.
        ```

    - 중복된 자동차 이름

        ```java
        input : John,Jane,John
        output : IllegalArgumentException - 자동차 이름이 중복됩니다. ("John"이(가) 중복됨)
        ```

    - 5글자 초과의 자동차 이름

        ```java
        input : John,Jane,Michael
        output : IllegalArgumentException - 자동차 이름을 5글자 이하로 지정해야 합니다.("Michael"이(가) 5글자 초과)
        ```

- 시도할 횟수 유효성 검사 예외 처리
    - 공백 입력

        ```java
        input : 
        output : IllegalArgumentException - 시도할 횟수가 입력되지 않았습니다.
        ```
      
    - 문자 입력

        ```java
        input : ㅁ
        output : IllegalArgumentException - 시도할 횟수는 숫자로 입력되어야 합니다.
        ```

    - 음수 입력

        ```java
        input : -1
        output : IllegalArgumentException - 0 이상의 숫자를 입력해 주세요.
        ```
---