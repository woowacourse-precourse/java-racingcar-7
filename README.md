# java-racingcar-precourse

## ✅ 구현할 기능 목록

### 📌 입력부
- [ ] 경주할 자동차의 이름을 입력받는다.
  - 참가자는 20명으로 제한한다(f1 2024 시즌 기준 한 경기 출전 선수 20명)
- [ ] 공백 제거
  - 입력을 받은 뒤에 공백을 모두 제거한다.
  - 아무 것도 입력하지 않았다면 `IllegalArgumentException`을 발생하고 종료한다.
- [ ] 이름의 규칙 
  - 이름은 5자 이하만 가능하다.
  - 오직 영어 소문자와 숫자 조합만 가능하다.
  - 영어 소문자 또는 숫자가 아닌 다른 문자가 이름으로 지정되었다면 예외를 발생(Name Error)
- [ ] 쉼표 구분자
  - 공백을 제거한 문자열에서 쉼표가 있는지 확인한다. 쉼표가 있다면 쉼표를 기준으로 split
  - 쉼표가 전혀 없다면 하나의 참여자인 것인데, 이름의 규칙에 위배된다면 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.

### 📌 무작위 값 구하기

- [ ] `Randoms`의 메서드를 사용해서 무작위의 값을 출력하기
  ```java
  public class Main {
      public static void main(String[] args) {
          int count = 200; // 출력할 숫자의 개수
  
          IntStream.generate(() -> Randoms.pickNumberInRange(0, 9)) // 무작위 숫자 생성
                   .limit(count) // 원하는 개수만큼 제한
                   .forEach(num -> System.out.print(num + " ")); // 출력
      }
  }
  ```
  
### 📌 커스텀 예외 적용하기

- [ ] 잘못된 형식의 이름을 입력한 경우(`InvalidUserNameException`)
- [ ]