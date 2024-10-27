## 자동차 경주

### 기능 요구 사항에 기재되지 않은 내용 추가 정의
- 자동차 경주는 한 번에 2개 이상, 5개 이하의 자동차만 가능하다.
- 한 번의 실행 내에서 자동차 이름은 중복될 수 없다.
- 입력 된 자동차 이름들 중 공백이 포함되어 있을 수 없다.
- 자동차 이름은 7자 이하만 가능하다
- 자동차 이름은 영어 대소문자로만 이루어져 있다.
- 이동 횟수는 1회 이상 10회 이하이다.
- 이동 횟수는 정수만 입력할 수 있다.
- 우승한 자동차가 없는 경우 `최종우승자 : 없음` 출력

### 구현 기능 목록
- 경주할 자동차 이름 입력받기
  - 자동차 이름 입력 가이드 문구 출력
  - 자동차 이름 입력 받기
  - 쉼표(,)로 구분하여 저장
- 몇 번의 이동을 할 것인지 입력받기
  - 이동 횟수 입력 가이드 문구 출력
  - 시도 횟수 입력 받기
- 자동차 전진
  - 자동차별 무작위 값(0~9) 생성
  - 무작위 값 4이상/이하 구분하여 자동차 이동
  - 이동 상황 출력
- 자동차 경주 결과
  - 우승자 결정
  - 우승자 출력, 여러명인 경우 쉼표(,)로 구분
- 사용자의 잘못된 입력에 대해 `IllegalArgumentException` 발생
  - 1개 이하 또는 6개 이상의 자동차 이름 입력  
  - 중복된 자동차 이름이 존재
  - 자동차 이름 중 공백 포함
  - 8자 이상의 자동차 이름 존재
  - 자동차 이름에 영어 대소문자 외의 문자/숫자 등이 존재
  - 정수가 아닌 이동 횟수 입력
  - 0 이하 또는 11 이상의 이동 횟수 입력

---

### 제공 라이브러리
| camp.nextstep.edu.missionutils

**Randoms**
- `ThreadLocalRandom.current()`를 통해 난수 생성기(defaultRandom) 초기화
- `pickNumberInList()`
    - numbers(Integer List)를 입력 받음
    - `validateNumbers()`를 통해 numbers가 비어있는지 검사
    - `pickNumberInRange()`에서 defaultRandom을 통해 범위에서 랜덤한 숫자를 생성, 지정한 시작값과 더해 무작위 숫자를 반환 받음
    - `validateRange()`를 통해 범위의 양 끝 유효성을 확인하고, Integer의 최대값을 초과하는지 검사
- `pickUniqueNumbersInRange()`
    - `validateRange()`를 통해 범위의 양 끝 유효성을 확인하고, Integer의 최대값을 초과하는지 검사
    - `validateCount()`를 통해 count 값이 0보다 작거나 범위 내의 값인지 검사
    - 주어진 범위의 숫자들을 numbers 배열에 추가
    - `suffle()`에서 java.util.Collections의 suffle()을 통해 numbers의 수를 무작위로 섞고,  
      count 수 만큼의 숫자 배열을 반환
      
**Console**
- `getInstance()`
    - java.util.Scanner 객체가 존재하지 않는 경우(scanner==null) **새로운 Scanner 객체 생성**
    - null이 아닌 경우는 **이미 존재하는 scanner 반환**
    - 생성된 **Scanner 객체 반환**
- `readLine()`
    - getInstance() 로부터 **Scanner 객체를 받음**
    - Scanner 객체의 nextLine()을 통해 한 줄의 문자열을 읽어 옴  
      (사용자가 Enter 키를 누를 때 까지, Enter 키는 버림)
- `close()`
    - 현재의 scanner가 null이 아니라면, **열려있는 Scanner 객체 닫기**
    - 그 후 scanner를 null로 설정

**DateTimes**
- `now()`
    - 시스템의 현재의 날짜와 시간을 LocalDateTime 객체로 반환
