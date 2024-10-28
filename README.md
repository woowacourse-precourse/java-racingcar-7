# java-racingcar-precourse
## 기능별 구현 클래스

#### 📂InputCarName
+ *자동차 입력받는 클래스*
- [x] 경주할 n 대의 자동차 이름 받기
- [x] 구분자를 통해 리스트에 자동차 이름 넣기

#### 📂DelimiterName
- [x] 입력값을 구분자 쉼표(,)로 받기
+ 자동차 입력받기, 우승자 출력하기 두 번 사용

#### 📂InputAmountOfRace
- [x] *이동횟수 입력받는 클래스*
- [x] 이동 횟수 입력받은 후 숫자로 반환

#### 📂RandomNumber
+ *자동차 전진여부를 결정하는 클래스*
+ 자동차마다 0에서 9 사이의 무작위값 할당

#### 📂RaceOrNot
+ 만일 무작위 값이 4 이상이면 전진, '-' 제공
+ 무작위 값이 4 미만이면 멈춤, 아무것도 입력하지 않는다
+ 이동 횟수만큼 반복하고 루프 탈출

#### 📂OutputRacing
+ *차수별 실행 결과 출력*
+ 리스트 이름 ":" '-' 출력값
+ 매 race turn 마다의 결과 출력

#### 📂RacingResult
+ *전체 실행 결과 출력*

#### 📂OutputWinner
+ *최종 우승자 출력*
+ 한명인 경우 그냥 출력
+ 여러 명인 경우, 구분자 쉼표(,)로 리스트 내역 출력

---

#### ⚠️IllegalArgumentException
+ *잘못된 값을 입력하는 경우*
+ 이름이 5자 이상인 경우
+ 이동횟수가 숫자가 아닌 경우


