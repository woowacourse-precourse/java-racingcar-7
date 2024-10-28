# java-racingcar-precourse

### 1. 입출력 처리

- **기능**: 사용자에게 콤마(,)로 구분된 자동차 이름 문자열과 경주 실행 횟수를 입력받아 경주를 진행한다. 
    0-9 사이의 숫자를 랜덤으로 추출하여 4이상인 경우 전진할 수 있다. 입력 받은 실행횟수만큼 경주 진행 후
    최종 우승자를 출력한다. 최종 우승자는 한 명 이상이 될 수 있다.


- **형식**:
    ```
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    시도할 횟수는 몇 회인가요?
    3
    
    실행 결과
    pobi : -
    woni :
    jun : -
    
    pobi : --
    woni : -
    jun : --
    
    pobi : ---
    woni : --
    jun : ---
    
    최종 우승자 : pobi, jun
    ```

### 2. 로직 구현

- **조건**
    - 자동차 목록 문자열과 실행 횟수는 반드시 값이 존재해야 함
    - 자동차들의 이름은 중복될 수 없음
    - 자동차들의 이름은 5자 이하만 허용
    - 실행 횟수는 양수로 제한
    - 최종 우승자는 여러 명이 될 수 있음


- **기능 순서**
    1. 자동차 목록 문자열, 실행 횟수 입력 받기 (`InputProcesser`)
    2. 자동차 객체 생성 (`Car`)
    3. 실행 횟수만큼 경주 실행 (`RaceManager`)
    4. 실행 시 마다 자동차의 이름과 전진한 거리 출력 (`OutputProcesser`)
    5. 경주 종료 후 전진한 최대 거리 산출 (`RaceManager`)
    6. 최종 우승자 선정 (`RaceManager`)
    7. 우승자 출력 (`OutputProcesser`)
  
    * `GameManager`는 전체 서비스 로직을 실행하는 `run()`을 가지고 있는 클래스

<hr>

### Commit Convention

- `feat` feature 새로운 기능 추가
- `fix` bug fix 버그 수정
- `docs` documentation 문서 수정
- `style` 코드 포맷팅, 세미콜론 누락 등
- `refactor` 코드 리팩토링
- `test` test 코드 추가
- `chore` maintain (잡일), 빌드 업무 수정, 패키지 매니저 수정