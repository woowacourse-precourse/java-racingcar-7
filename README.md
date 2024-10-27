# java-racingcar-precourse
## 자동차 이름 입력 받기
- Console.readline()을 이용하여 입력
- 콤마(,)를 기준으로 자동차 이름 분리
- 분리한 이름을 5글자 초과인지 검사
  - 5글자 초과 시 IllegalException 발생
- 검사 후 LinkedHashMap에 <자동차 이름, 0>으로 초기화하여 저장

## 경주 횟수 입력 받기
- Console.readline()을 이용하여 입력
- 입력 타입이 String이므로 int형으로 캐스팅
## 경주 과정
- 과정마다 전진한 자동차 표식을 위해 String 변수에 특수문자 저장
- Randoms.pickNumberInRange(0,9) 메소드를 이용해 각 자동차마다 0~9 범위의 임의 숫자 부여
- 4 이상일 시 앞으로 전진 -> Map의 value 값에 +1
- 각 게임마다 자동차의 전진 여부 출력
- 가장 많이 전진한 자동차의 value 값 구하기
- 최대 value을 이용하여 우승자 구하기
- 우승자 출력

## 코드 작성 과정
1. main() 내에 프로그램을 순차적으로 구현한다
2. 하나의 기능이 있을 때마다 메소드로 추출한다
3. 메소드 형식, 흐름에 맞게 서로를 연결한다