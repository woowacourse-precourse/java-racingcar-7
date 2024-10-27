# 기능 목록
- **자동차 이름 입력**
    - **"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"** 
    - 이름은 쉼표(,) 기준으로 구분

- **시도 횟수 입력**
  - **시도할 횟수는 몇 회인가요?**

- **유효성 검사**
  - Case1. 자동차 이름
    - 5글자 이상인 경우 : **"자동차 이름은 5글자 이하로 입력 해야합니다."**
    - 입력을 하지 않은 경우 : **"자동차 이름이 입력되지 않았습니다."**
    - 공백을 포함한 경우 : **"공백을 포함하면 안됩니다."**
  - Case2. 시도 횟수
    - 음수 혹은 0인 경우 : **"시도 횟수는 양의 정수로 입력 해야합니다."**
    - 입력을 하지 않은 경우 : **"시도 횟수가 입력되지 않았습니다."**

- **경주 진행**
  - **시도 횟수 만큼 아래 반복**
    1. 각 자동차별 0~9사이 무작위 값 구하기
    2. 값이 4이상인 자동차를 체크하기
    3. 결과를 출력하기

- **우승자 출력**
  - 가장 많이 전진한 사람을 출력
    - 한 명일 경우 : **"최종 우승자 : pobi"**
    - 여러 명일 경우 : **"최종 우승자 : pobi, jun"**
---
### 주의 사항
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.