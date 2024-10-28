### 최종 목표: 다른 사람들에게 코드 의사 전달이 '잘' 되게 과제 만들기

---

## 중간 점검 및 피드백

<details>
<summary> ❗️패키지 문맥을 놓쳐서 생긴 네이밍 실수들</summary>

개발하면서 이름의 의도를 잘 드러내기 위해 이름을 길게 했다. 그러다보니 각각의 클래스들을 합치다 보니 중복된 이름들이 다수 존재했다

## 문제 예시

```java
// 예를들어
class RacingCarGame {
    GamePlayer gamePlayer;
}

class GamePlayer {
    RacingCar car;

    void playGame();
}

class RacingCar {
}

// 결과
// 너무 많은 Racing 문맥 중복
RacingCarGame → GamePlayer → RacingCar
```

🔥 객체들간의 관계를 생각 안 하고 독립적으로 클래스들을 만들어 네이밍을 자세히 만들었더니, 합쳤을 때 중복이름들이 발생해서 오히려 가독성이 떨어졌다.🔥

뒤늦게 깨달아 한숨이 많이 나왔었고, 1주차 피드백 문서를 `중복이름으로 가독성저하 문제해결관점`으로 정독 했다.

- 나자신 그리고 다른사람들과의 소통을 위해서,서 클래스역할,함수역할,변수역할에 대한 `의도`를 드러내어 혼란을 방지한다.
- 의도를 드러낼 수 있다면 이름이 길어져도 좋다. 하지만 길게 해서 `문맥`을 중복해서 혼란을 일으키면 안된다.
    - 예를 들어 클래스 이름이 Order라면 shipOrder라고 메서드 이름을 지을 필요가 없다. - Order라는 중복이 문맥을 끊는다.
    - 짧게 ship이라고 하면 클라이언트에서는 order.ship()라고 호출하며, 간결한 호출의 표현이 된다.

내 문제는 클라이언트를 무시한채, 문맥 중복으로 인해 의도를 드러내지 못했다.

이제는 클라이언트(호출하는 쪽)을 제대로 고려하여 문맥의 의도를 드러내는 것을 목표로 한다.
그렇다면 위의 문제 코드를 어떻게 해결하면 좋을까?

## 문제 예시 - 리팩토링!

먼저 문맥 중복된 부분을 잘라냈다.

```java
class Game {
    Player player;
}

class Player {
    Car car;

    void play();
}

class Car {
}

// 결과
// Racing 문맥이 사라짐, 한편 의도 명확성 증가 
Game->Player->Car
```

사라진 Racing 문맥을 어떻게 살려낼지 코드를 한참 보다가,
2주차 패키지구조가 racingcar로 '왜' 만들어졌을까 고민하니까 racingcar의 맥락을 먼저 제공해준것임을 자각하게됐다.

### 깨달은점

나는 지금까지 각각의 객체에 큰맥락을 포함시키려고 노력했던 것이였다.
제공받은 패키지가 `왜 racingcar로 제공해줬을까?` 생각 못하고 개발하고 있었다.
즉, 패키지의 의미를 외면한채 개발하고 있었다.
이번 기회로 패키지의 활용성을 다시 공부하고 어떻게 더 잘 활용할 수 있을지 고민하면서 개발해야겠다.



</details>


<details>
<summary> ❗개발에 빠져 잊고 있던 커밋 메시지의 본질</summary>

## 내 커밋들.. 잘 안읽히는 것 같다.

내 커밋 메시지를 다시 확인해봤다.
지금 나는 너무 개발에만 빠져 들어 커밋 메세지 작성을 소홀히 하고 있는 것 같다.

- feat: 플레이어가 자동차를 앞으로 움직이는 기능 추가 -> 더 간결하게 할 수 있을 것 같은데? feat인데 기능추가는 중복 인듯?
- feat: 게임넘버제너레이터로부터 숫자 뽑기 기능 추가 -> '누가?' 했는지 드러나지 않아서 아쉽고, 어떻게 개발하는지까지 읽어야하니까 무엇을 개발했는지 한 눈에 안 보이는 문제가 있다.

인사이트를 얻기 위해 여러 글들을 찾아보고 다음과 같이 개선 했다.

> - (변경 전) feat: 플레이어가 자동차를 앞으로 움직이는 기능 추가
> - (변경 후) feat: 플레이어 자동차 이동 구현
>
> - (변경 전) feat: 게임넘버제너레이터로부터 숫자 뽑기 기능 추가
> - (변경 후) feat: 플레이어 랜덤 이동 조건 구현

지금부터라도.. 내 커밋을 볼 사람들을 생각하면서 더 신중하게 작성해야겠다.
아래는 1주차 피드백 문서 내용이다.

### '팀'의 좋은 코드 리뷰 문화는 '작은 커밋'을 작성하는 것에서 비롯된다.

> ### 1. 제목과 본문은 한 줄 띄워 분리하기
>
> 정말 간단할때는 다음과 같이 할 수도 있다
>  - 쌍따옴표 한 개 빼먹었다..--; 수정
>  - 어제부로 저장소 URL이 바뀜. URL 한 개만 업데이트
>
> 하지만! 간단히 안된다면 제목과 본문에 하나의 라인을 띄우자. git log를 찍었을 때 전부 붙여져 뚱뚱히 보인다.

> ### 2. 제목은 영문 기준 50자 내로
> - 가장 간결히 요약된 제목 유도하기

> ### 3. 제목 끝에 '.' 금지
> - 영문법의 문제긴 하다. 하지만 .을 안쓴다면 문장 대신 간결한 구문들로 제목을 지을 수 있다.

> ### 4. 제목은 간결한 구문으로
> 제목: 무엇을 했는지 간단히
> 예를 들어 다음과 같이 작성할 수 있다.
> ```java
> // 1. 기능 추가시
> // 패턴: feat: [기능명] [동작] 기능 추가
> feat: 포인트 적립 계산 기능 추가
> feat: 회원 등급 자동 승급 기능 추가
> feat: 이메일 인증 발송 기능 추가
> 
> // 2. 버그 수정시
> // 패턴: fix: [문제상황] [해결방안] 수정
> fix: 장바구니 상품 중복 추가 방지 로직 수정
> fix: 주문 취소시 재고 미반영 문제 수정
> fix: 회원 포인트 소수점 절사 오류 수정
> 
> // 3. 리팩토링시
> // 패턴: refactor: [대상] [개선사항] 분리/개선
> refactor: 주문 처리 로직 단일 책임 원칙에 따라 분리
> refactor: 상품 조회 메서드 성능 개선
> refactor: 결제 처리 중복 코드 제거
> 
> 잘못된 예시
> // 너무 길고 자세함
> feat: PlayerValidator 클래스를 추가하고 PlayerService에서 검증 로직을 분리하여 단일 책임 원칙을 준수하도록 개선
> // 어떻게에 초점이 맞춰짐
> feat: PlayerValidator 클래스 생성 후 메서드 추가
> ```

> ### 5. 본문은 `어떻게`보다 `무엇을`, `왜`에 맞춰 작성하기
> - `어떻게`는 코드를 보면 알 수 있고, 코드만으로는 `무엇을`,`왜`같은 의도와 맥락을 파악하기 어렵다.
> - 변경 이유를 먼저 알면, 나중에 해당 코드를 수정/제거할 때 더 좋은 판단 가능
> - 제목에서 무엇을 했는지 간단히 설명 했으니, 본문은 왜 했는지 설명하는게 좋음
> - ```java
>   // BAD - 어떻게에 초점
>   PlayerService에 validatePlayersCount 메서드를 추가하고
>   PlayerValidator 클래스로 검증 로직을 이동시킴
>   
>   // GOOD - 무엇을, 왜에 초점
>   플레이어 수 검증 로직을 분리하여 단일 책임 원칙 준수
>   - 플레이어 생성과 검증 책임을 분리하여 코드 응집도 향상
>   - 향후 검증 로직 변경/확장이 용이하도록 개선"
>   ```

    >   ```java

> // BAD
> 게임 라운드 횟수 검증을 위해 if문 추가
>
>   // GOOD
> 게임 라운드 횟수 유효성 검증 추가
>   - 잘못된 라운드 횟수로 인한 게임 진행 버그 방지
>   - 최소1회, 최대 100회로 제한하여 시스템 리소스 보호
>
>

```
- 타입 규칙 - 
feat: 새로운 기능 추가 밍
fix: 버그 수정
refactor: 코드 리팩토링 (기능변경 없음)
style: 코드 포맷팅, 세미콜론 누락 등 스타일 변경
test: 테스트 코드 추가/수정
docs: 문서 수정
chore: 빌드 관련 파일 수정
```

</details>

<details>
<summary> ❗️무심코 지나쳤던 정리된 기능목록서의 낙숫물 효과</summary>

## 발단:

`보기 좋은 네이밍을 고민하다가` → `패키지 구조의 중요성을 깨달음` → `패키지 구조를 잘 설계하는 방법을 고민` → `기능 요구사항을 탄탄히 세우자는 결론`

발단:  보기좋은 네이밍 설계법을 탐구하다가 패키지 구조 설계의 중요성을 배웠고,<br>
어떻게 패키지 구조를 잘 설계할 수 있을지 고민하다가 내린 결론은 바로 `'기능 요구사항을 탄탄히 세우자'` 였다.
<br> 왜 이런 결론을 내렸냐면, 지금까지 내 개발 프로세스는 어땠는지 뒤돌아보니까 못봤던 문제점들이 보이기 시작했다.
전체를 생각을 전혀 안하고, 우선 하나씩 개별 도메인의 요구사항을 구현하면서
그때그때 패키지 구조를 추가해나가고 있었다.
이렇게 독립적으로 기능 요구사항을 추가하다보니 같은 레벨에 있는 패키지들간의 중복된 맥락이 자꾸 생기게 됐다.
이런 실수를 방지하려면 결국 처음부터 과제 진행 요구사항을 제대로 정리하고 시작해야 한다는 동기가 생기게 됐다.

동기가 생기다 보니, 2주차 프로코스 문서를 다시 읽어보게 됐다.

2주차 프리코스 `과제 진행 요구사항1`에 다음과 같이 명시 돼있다.

- `기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.`
- `Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.`
- AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.

왜 제목이 `과제 진행`이고, 왜 `요구사항에 1`이 붙었는지 그 이유를 이제야 알 것 같다.<br>
직접적으로 왜 이렇게 해야하는지 알려주지는 않았지만, 제대로 방향을 알려주고 있었다.

구현할 기능 목록의 `정리`에서 `정리`란 `흐트러지거나 혼란스러운 상태에 있는 것을 한 곳에 모으거나 치워서 질서 있는 상태가 되게 함`을 의미한다.

만약 기능 목록 정리를 안한다면, 도미노처럼 혼란이 커질 것이다. `정리 안된 기능 목록`→`패키지 설계` → `클래스 네이밍` → `메서드 네이밍` → `상수 네이밍`

후후.... 나는 망했다. 이거 언제 다 수정하지 ? 밤 새야 되나?

## 나아가기:

어떻게 기능 목록 `정리`를 `잘` 할수 있을까?<br>
인터넷에 찾아본 결과 구체적인 기능을 적을수록 정리된 목록서라는 글을 많이 봤다.
<br> 그래서 나도 구체적으로 작성했었다. 하지만 개발이 완성되고, 메서드의 길이를 줄이기 위해 분리해낼 수록 목록서를 수정하는 번거로움이 많았다.

```java
// 작성했었던 기능 목록서
[x]게임 횟수,자동차들을 받아 자신을 생성한다.
        -게임횟수그리고자동차들입력받으면_생성한다
        -자동차최대5대초과시_예외처리
        -자동차최소2대미만시_예외처리
        -게임횟수100번초과시_예외처리
        -게임횟수1번미만시_예외처리
```

누군가 피드백을 해줬으면 좋겠다 생각했을 때!
1주차 코드 리뷰하는 사람들의 기능 목록서 작성들을 수십 개 정독 했다.

다양한 사람들의 목록서를 읽을 수록, 정리 된 목록서가 무엇인지 피드백을 받았고 내 생각을 정리했다.

### `정리 된 기능 목록`이란

> <h3>1.적절한 추상화 수준을 유지하는 목록</h3>
> - 너무 세부적이지 않아 리팩토링 시 수정이 빈번하지 않음
> - 하나의 책임을 명확하게 표현하는 수준으로 작성
> ````java서
>   // 예시:
>   기존: "게임횟수그리고자동차들입력받으면_생성한다"
>   개선: "게임 설정값 검증하기"
> ````


> <h3>2. 도메인 맥락을 반영하는 목록</h3>
>  - 비즈니스 요구사항을 기준으로 기능을 구분
>  - 패키지 구조 설계의 기반이 될 수 있는 수준
> ````java
>    // 예시:
>   - [게임 설정]
>    - 게임 설정값 검증하기
>    - 자동차 대수 검증하기
>    - 게임 횟수 검증하기
> ````


> <h3>3. 관련 기능끼리 그룹화된 목록</h3>
>  - 연관된 기능들을 카테고리로 묶어서 표현
>  - 패키지 간 중복된 맥락이 생기지 않도록 사전에 방지
> ````java
>    // 예시:
>   - [게임 진행]
>    - 자동차 이동하기
>    - 라운드 진행하기
>   - [게임 결과]
>    - 우승자 판단하기
>    - 게임 결과 출력하기
> ````
>




</details>
---

# 프리코스 2주차 도입하기

초간단 자동차 경주 게임을 구현한다.



<details>
<summary> 입출력 요구사항</summary>

## 입력

경주할 자동차 이름을 쉼표(,)로 구분하여 여러개 받는다.
게임 시도할 횟수를 정수 1~20까지만 입력 받을 수 있다.

- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 출력

- 차수별로 실행 결과를 "{이름} : {이동횟수}" 형식으로 사용자 수 만큼 출력한다.
    - 이동횟수는 "-" 갯수이고, 문자를 붙여서 출력해야한다.
    - 이동횟수가 없을 경우 ""으로 처리한다.

```java
// 차수별 실행 결과
pobi:--
        woni:----
        jun: 
```

- 최종 우승자를 마지막에 출력하고, 게임을 종료한다.

```java
최종 우승자:pobi,jun
```

</details>

<details>
<summary> 기능 요구사항</summary>

# 기능 요구사항

## 자동차 경주 애플리케이션

- 게임 횟수가 주어지고 이 횟수만큼 자동차가 행동을 한다.
- 자동차는 n대 존재한다.
    - (0 < n <6)
- 자동차가 전진한다.
- 자동차가 멈춘다.
- 자동차는 이름이 있다.
- 전진한 자동차 이름, 전진한 횟수를 함께 출력한다.
- 사용자는 총 이동 횟수를 입력한다.
- 자동차 전진 조건은 도출된 무작위 값이 4 이상인 경우다
    - (0~9 사이로 무작위 값을 구한다.)
- 자동차 경주 게임을 완료된 후, 우승자를 출력한다.성
    - (우승자는 한 명 이상일 수 있다.)
    - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

</details>

---

## 📋 구현할 기능 목록

## 🚗 자동차

목적 :

- 자동차 경주 게임에서 사용될 자동차 도메인 객체의 구현
- 자동차의 이름과 위치를 관리하는 불변 객체 제공

---

<h2>1. 자동차(Car) 유스케이스 </h2>
<h4>

- [x] 자동차 생성하기
    - [x] 정상적인 자동차 생성
    - [x] 빈 이름으로 자동차 생성 시도
    - [x] 너무 긴 이름으로 자동차 생성 시도
    - [x]  null 이름으로 자동차 생성 시도


- [x] 자동차 이동하기
    - [x] 새로운 위치로 자동차 이동
    - [x] 연속적인 자동차 이동


- [x] 자동차 위치 확인하기
    - [x] 같은 위치와 비교
    - [x] 다른 위치와 비교
      </h4>

<h2>2. 이름(Name) 유스케이스</h2>

<h4>

- [x] 이름 생성하기
    - [x] 정상적인 이름 생성
    - [x] 최소 길이 미달 이름으로 생성 시도
    - [x] 최대 길이 초과 이름으로 생성 시도
    - [x] null 값으로 생성 시도

</h4>



<h2>3. 거리(Distance) 유스케이스 </h2>

<h4>

- [x]  거리 생성하기
    - [x] 특정 값으로 거리 생성
    - [x] 초기 거리(0) 생성


- [x] 거리 더하기
    - [x] 두 거리 더하기

</h4>

---

## 🕹️ 플레이어

목적 :

- 자동차 경주 게임에서 사용될 플레이어 객체의 구현
- 플레이어의 Id와 자동차를 관리하는 불변 객체 제공

<h2>1. 단일 플레이어(Player) 유스케이스 </h2>

<h4>

- [x] 플레이어 생성하기
    - [x] 정상적인 플레이어 생성
    - [x] 잘못된 이름으로 플레이어 생성 시도


- [x] 플레이어 이동하기
    - [x] 새로운 위치로 플레이어 이동


- [x] 플레이어 정보 조회하기
    - [x] 플레이어 ID 조회
    - [x] 플레이어 이름 조회
    - [x] 플레이어 위치 조회
      </h4>

<h2>2. 플레이어 그룹(Players) 유스케이스 </h2>

<h4>

- [x] 플레이어 그룹 생성하기
    - [x] 정상적인 플레이어 그룹 생성
    - [x] 최소 인원 미달로 생성 시도
    - [x] 최대 인원 초과로 생성 시도
    - [x] 중복된 이름으로 생성 성공


- [x] 플레이어 그룹 업데이트하기
    - [x] 플레이어 정보 업데이트


- [x] 전체 플레이어 조회하기
    - [x] 모든 플레이어 목록 조회

</h4>

---

## 🎮 게임

목적 :

- 자동차 경주 게임에서 사용될 게임 객체의 구현
- 게임의 Id와 자동차를 관리하는 불변 객체 제공

<h2>1. 게임(Game) 유스케이스</h2>

<h4>

- [x] 게임 시작하기
    - [x] 정상적인 게임 생성
    - [x] 최소 플레이어 수 미달로 게임 생성 시도
    - [x] 최대 플레이어 수 초과로 게임 생성 시도
    - [x] 최소 라운드 수 미달로 게임 생성 시도
    - [x] 최대 라운드 수 초과로 게임 생성 시도


- [x] 게임 진행하기
    - [x] 정상적인 라운드 진행
    - [x] 종료된 게임 진행 시도


- [x] 게임 종료 확인하기
    - [x] 진행 중인 게임 확인
    - [x] 종료된 게임 확인


- [ ] 승자 확인하기
    - [ ] 단독 승자 확인
    - [ ] 공동 승자 확인

<h2>2. 이동 정책(MovementPolicy) 유스케이스</h2>

<h4>

- [x] 이동 여부 결정하기
    - [x] 이동 조건 충족
    - [x] 이동 조건 미충족

</h4>

---

## Controller

<h2> 1. 게임 컨트롤러(GameController) 유스케이스 </h2>

<h4>

- [ ] 게임 시작하기
    - [ ] 정상적인 게임 시작

---

## Service

<h2> 1. 게임 서비스(GameService) 유스케이스 </h2>

<h4>

- [x] 게임 초기화하기
    - [x] 정상적인 게임 초기화


- [x] 라운드 진행하기
    - [x] 정상적인 라운드 진행
    - [x] 정상적인 게임 결과 반환
    - [x] 게임 비초기화시 라운드 진행 시도


- [x] 다음 라운드 확인하기
    - [x] 다음 라운드 존재 확인
    - [x] 다음 라운드 없음 확인


- [ ] 승자들 조회하기
    - [ ] 단독 승자 조회
    - [ ] 공동 승자 확인

</h4>


<h2> 2. 플레이어 서비스(PlayerService) 유스케이스  </h2>

<h4>

- [x] 플레이어 등록하기
    - [x] 정상적인 플레이어 등록
    - [x] 부적절한 이름으로 등록 시도


- [x] 플레이어 전체 조회하기
    - [x] 정상적인 플레이 전체 조회

</h4>


---

## Repository

<h2> 1. 플레이어 레파지토리(PlayerRepository) 유스케이스 </h2>


<h4>

- [x] 플레이어 저장하기
    - [x] 정상적인 플레이어 저장


- [x] 단일 플레이어 id로 조회하기
    - [x] 정상적인 단일 플레이어 조회
    - [x] id가 Null일때 조회 시도


- [x] 플레이어 전체 조회하기
    - [x] 정상적인 전체 플레이어 조회

---

## 실행 결과 예시

```java
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)
        pobi,woni,jun
        시도할 횟수는 몇 회인가요?
        5

        실행 결과
        pobi:-
        woni:
        jun:-

        pobi:--
        woni:-
        jun:--

        pobi:---
        woni:--
        jun:---

        pobi:----
        woni:---
        jun:----

        pobi:-----
        woni:----
        jun:-----

        최종 우승자:pobi,jun
```