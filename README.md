# 자동차 경주
**초간단 자동차 경주 게임 구현**<br>
**주어진 횟수 동안 n대의 자동차는 전진 또는 정지**<br>
**각 자동차에 이름을 부여하고, 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.**<br>
**자동차 이름은 쉼표 `(,)` 를 기준으로 구분하며 이름은 5자 이하만 가능하다.**<br>
**사용자는 이동 횟수를 입력**<br>
**전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 그 값이 4이상일 경우이다.**<br>
**모든 이동 완료 후, 우승자를 출력한다. 우승자는 한 명 이상일 수 있고, 그 경우 쉼표 `(,)` 를 이용하여 구분한다.**<br>
**사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료** 

## 프로그래밍 요구 사항

1. **Indent Depth 제한**
    - 들여쓰기 깊이(indent depth)는 2까지만 허용
    - 예: `while` 문 안에 `if` 문이 있으면 들여쓰기는 2이다

2. **복잡성 줄이기**
    - Indent depth를 줄이기 위해 함수(또는 메서드)를 분리해 사용
    - 삼항 연산자는 사용하지 않는다

3. **함수의 단일 책임 원칙**
    - 함수(또는 메서드)는 한 가지 일만 하도록 최대한 작게 만들 것

4. **JUnit 5와 AssertJ 활용**
    - 정리된 기능 목록이 제대로 작동하는지 테스트 코드로 확인

## 기능 요구 사항

1. **사용자 입력 받기**
   - [x] 경주 할 자동차 이름 입력
     - [x] 이름은 쉼표 `(,)` 기준으로 구분
     - [x] 입력한 문자의 길이는 5자 이하
   - [x] 시도할 횟수 입력 받기
     - [x] 횟수는 정수로 입력받는다.
2. **경주 게임 구현**
   - [x] 전진 기능 
     - [x] 무작위 값 입력 받기
     - [x] 무작위 값에 따른 전진 또는 정지 기능
   - [x] 입력한 횟수 만큼 반복 기능 
     - [x] 횟수 마다 현재 상황 출력
   - [x] 우승자 출력 기능 
     - [x] 마지막 횟수 종료 시, 우승자 이름 출력
     - [x] 여러명일 경우, 쉼표 `(,)` 를 기준으로 구분
3. **예외 처리**
   - [x] 입력받은 자동차의 이름이 5자 초과 시
   - [x] 시도할 횟수가 음의 정수 이거나 0일 시
   - [x] 시도할 횟수에 숫자가 아닌 값 입력 시
   - [x] 빈 문자열이나 유효하지 않은 문자열 입력 시
   - [x] 중복된 자동차 이름 입력 시