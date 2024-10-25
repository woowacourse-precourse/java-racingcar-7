# 기능 구현 목록

---

## ✅ 객체 지향적 코드 작성하기.

### `Car 객체 ( distance 와 name 객체 보유)`

- [x]  자동차는 이름과 이동 거리를 가지고 있다
- [x]  자동차의 이름은 5자 이하만 가능하다 → 잘못되면 illegalArgumentException
- [x]  자동차는 전진 기능이 있다. (무작위 수가 4이상인 경우 전진)

### `Cars 객체 (일급 컬렉션)`

- [x]  Car들을 가지고 있다
- [x]  보유하고 있는 차들을 전진시키는 기능
- [x]  현재 점수를 뽑아내는 기능
- [x]  우승자를 추출하는 기능

### `CarRecord, RaceRoundRecord, RaceRecord`

- [x]  정적 펙토리 매서드로 엮어서 만들기 쉽게 구현

### `InputView`

- [x]  , 를 기준으로 이름을 입력받는다
- [x]  Token 입력에 대한 기능 구현

### `Output View`

- [x]  라운드 마다 결과를 출력한다
- [x]  최종 우승자를 출력한다

### `raceResultView`

- [x]  각 회차의 결과를 출력한다. ( 자동차 이름과 distance)
- [x]  단독 혹은 다수의 우승자를 출력할 수 있다 , 로 구분해서 출력한다.

### `randomMovementGenarator`

- [x]  로직이 바뀔 것을 대비해서 interface로 설계 후 구현체 설정
- [x]  RandomNumber 인터페이스를 주입받도록 설계

### `RandomNumber`

- [x]  로직이 바뀔 것을 대비해 interface로 설계
- [x]  getInstance를 통한 싱글톤 설계

### `GameController`

- [x]  컨트롤러 로직 구현

### `Application`

- [x]  의존성 주입

---

## ✅요구 사항

- [x]  미사용 importation 제거
- [x]  코드 컨밴션 체크 ( 간격, 들여쓰기 조건)
- [x]  의미없는 주석 제외

---

## ⭐ 전 주차 배운 내용 적용하기

- [x]  assertJ 를 사용해서 테스트하기 (given, when, then 형식)
- [x]  getInstance 싱글톤 사용하기
- [x]  적재적소에 interface 적용하기
- [x]  1 급 컬렉션으로 설계하기
- [x]  stream 적극 활용하기
- [x]  커밋 메시지 feedback 적용하기
- [x]  정적 펙토리 매서드로 생성하기