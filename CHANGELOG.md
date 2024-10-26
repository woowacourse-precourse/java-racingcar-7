# Change Log

<br>
<br>

## v1.2 (2024.10.27)

> 기타 변동 사항

- [[refactor]: 빈 문자열 상수화](https://github.com/Gilbert9172/java-racingcar-7/commit/f937742)
- [[fix]: 거리가 음수인 경우 예외처리와 중복되는 예외처리 제거](https://github.com/Gilbert9172/java-racingcar-7/commit/e4fe89e)
- [[refactor]: Speed 클래스의 패키지 위치 변경](https://github.com/Gilbert9172/java-racingcar-7/commit/d7f2733)

<br>
<br>

## v1.1 (2024.10.26)

---

> 주요 작업 : 리팩토링 및 TC 보강
>
> 작업 시간 : 1d

- [[b5450d7] refactor: Random 생성하는 수를 Speed라는 값 타입으로 관리하도록 개선](https://github.com/Gilbert9172/java-racingcar-7/commit/b5450d7)
- [[378763a] refactor: Constant 분리하여 보다 의미있는 도메인과 결합](https://github.com/Gilbert9172/java-racingcar-7/commit/378763a)
- [[22e9cdf] refactor: 생성자 NPE 체크하는 부분은 Objects를 사용하도록 변경](https://github.com/Gilbert9172/java-racingcar-7/commit/22e9cdf)
- [[6409e62] refactor: MyProgress 생성자에 Position 파라미터 복구 및 TC 리팩토링](https://github.com/Gilbert9172/java-racingcar-7/commit/6409e62)
- [[74169d5] refactor: MyProgress 팩토리 메소드의 파라미터에서 Position을 제거](https://github.com/Gilbert9172/java-racingcar-7/commit/74169d5)
- [[f7fdc08] refactor: 이동 후 새로운 Postion을 생성하는 부분을 별도의 클래스로 추출](https://github.com/Gilbert9172/java-racingcar-7/commit/f7fdc08)
- [[bf1059b] refactor: Lap의 필드 타입을 long으로 변경](https://github.com/Gilbert9172/java-racingcar-7/commit/bf1059b)
- [[566a2fc] refactor: 입력 값 예외처리에 사용하던 Facade 클래스를 두개로 분리](https://github.com/Gilbert9172/java-racingcar-7/commit/566a2fc)
- [[24d7181] refactor: 오류를 숨기는 코드 개선](https://github.com/Gilbert9172/java-racingcar-7/commit/24d7181)
- [[e62c164] refactor: 랜덤 값을 생성 후 이동하는 로직 리팩토링](https://github.com/Gilbert9172/java-racingcar-7/commit/e62c164)

<br>
<br>

## v1.0 (2024.10.25)

---

> 주요 작업 : 주요 기능 개발 및 로직 수정
>
> 작업 시간 : 2d

- [[df2eba0] fix: 우승자가 없는 경우 White space로 처리되던 부분 수정](https://github.com/Gilbert9172/java-racingcar-7/commit/df2eba0)
- [[4b3a26e] refactor: DashBoard 도메인 내 메소드명 변경](https://github.com/Gilbert9172/java-racingcar-7/commit/4b3a26e)
- [[83a30f0] feat: 도메인 예외처리 기능 개발](https://github.com/Gilbert9172/java-racingcar-7/commit/83a30f0)
- [[3818a48] feat: 중간 결과를 출력하는 기능 개발](https://github.com/Gilbert9172/java-racingcar-7/commit/3818a48)
- [[6bbd626] feat: 우승자 출력 view 개발](https://github.com/Gilbert9172/java-racingcar-7/commit/6bbd626)
- [[8e081d2] refactor: 구조 재조정](https://github.com/Gilbert9172/java-racingcar-7/commit/8e081d2)
- [[f3efb21] feat: 사용자의 입력 값(lapCount)을 받고 검증하는 기능 개발](https://github.com/Gilbert9172/java-racingcar-7/commit/f3efb21)
- [[0b4763e] feat: 사용자의 입력 갑을 받고 검증하는 기능 개발](https://github.com/Gilbert9172/java-racingcar-7/commit/0b4763e)
- [[b9fde14] feat: Controller 작업](https://github.com/Gilbert9172/java-racingcar-7/commit/b9fde14)
- [[b67e73b] feat: 핵심 비즈니스(경주 시작) 로직 개발](https://github.com/Gilbert9172/java-racingcar-7/commit/b67e73b)
- [[70cd66c] feat: DashBoard 도메인 기능 개발](https://github.com/Gilbert9172/java-racingcar-7/commit/70cd66c)
- [[d7b47fc] style: MyProgress를 car 패키지로 이동](https://github.com/Gilbert9172/java-racingcar-7/commit/d7b47fc)
- [[b8fdd1d] feat: 경주 현황을 파악하기 위한 기능 개발](https://github.com/Gilbert9172/java-racingcar-7/commit/b8fdd1d)
- [[88e512f] feat: 경주차를 이동하는 기능 개발](https://github.com/Gilbert9172/java-racingcar-7/commit/88e512f)
- [[9709478] feat: 내 경기 현황 갱신 기능](https://github.com/Gilbert9172/java-racingcar-7/commit/9709478)
- [[914ea53] feat: 랜덤 값에 따라 변경되는 이동거리를 구하는 기능](https://github.com/Gilbert9172/java-racingcar-7/commit/914ea53)
- [[4991ad6] feat: 경주 완료 여부 및 중간 진행 사항 확인하는 기능](https://github.com/Gilbert9172/java-racingcar-7/commit/4991ad6) 