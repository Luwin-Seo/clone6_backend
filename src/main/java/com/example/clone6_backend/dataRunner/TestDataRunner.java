package com.example.clone6_backend.dataRunner;

import com.example.clone6_backend.model.Fund;
import com.example.clone6_backend.model.User;
import com.example.clone6_backend.repository.FundRepository;
import com.example.clone6_backend.repository.RewardRepository;
import com.example.clone6_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestDataRunner implements ApplicationRunner {

    private final UserRepository userRepository;
    private final FundRepository fundRepository;
    private final RewardRepository rewardRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("1", passwordEncoder.encode("1"), "1");
        userRepository.save(user);

        List<Fund> funds = new ArrayList<>();

        Fund fund1 = new Fund();
        fund1.setTitle("[모공케어1위]모공볼륨개선 최대61.7% 단,2주만에 모공다이어트 성공");
        fund1.setSubTitle("모공이 고민이라면, 잘 오셨어요. 단, 1회 사용만으로 각질개선 97.07%, 2주만에 모공볼륨 최대 61.7% 토너 유목민들 마음을 저격할 올 여름 필수템. 에스스킨 모공쫀쫀토너");
        fund1.setImageURL("https://i.ytimg.com/vi/DFG7RQV9Ie0/hqdefault.jpg");
        fund1.setCategory("뷰티");
        fund1.setFundingGoal(500000L);
        fund1.setCurrentFund(1000000L);
        fund1.setExpDate(LocalDate.of(2022, 7, 11));
        fund1.setContent("https://btaeredux.s3.ap-northeast-2.amazonaws.com/%ED%94%BC%EB%B6%80-cutout.png");
        funds.add(fund1);

        Fund fund2 = new Fund();
        fund2.setTitle("흔들리는 너의 의지까지 잡아줄게! DOITDOEAT 홈트 레그웨어");
        fund2.setSubTitle("줄줄 흘러내리는 운동 양말은 이제 그만! 흔들리는 당신의 의지까지 잡아줄 세상에 없던 스펙의 홈트 전용 레그웨어 두잇두잇 | 골프, 필라테스, 등산에도 DOITDOEAT!");
        fund2.setImageURL("http://en.coii.kr/web/product/medium/2_Y3_knee_socks_460.jpg");
        fund2.setCategory("패션·잡화");
        fund2.setFundingGoal(500000L);
        fund2.setCurrentFund(1550000L);
        fund2.setExpDate(LocalDate.of(2022, 7, 11));
        fund2.setContent("https://btaeredux.s3.ap-northeast-2.amazonaws.com/%ED%99%88%ED%8A%B8-cutout.png");
        funds.add(fund2);

        Fund fund3 = new Fund();
        fund3.setTitle("[홍감자] 포슬포슬 분이 폭발하는, 달달한 감칠맛이 신기한 새로운 감자!");
        fund3.setSubTitle("[올해 첫 햇감자] 감자야? 고구마야? 카스테라처럼 포슬포슬, 포근포근. 분나는 홍감자를 만나보세요. 진하고 고소한 맛에 깊은 달달함까지. 신기하게 맛있는 신품종 감자랍니다!");
        fund3.setImageURL("https://mblogthumb-phinf.pstatic.net/20141118_7/nawarcham_1416272015433fl29Y_JPEG/%B0%ED_%BF%F4%B1%E4_%BB%E7%BF%AC_%B8%F0%C0%BD_0.jpg?type=w2");
        fund3.setCategory("푸드");
        fund3.setFundingGoal(500000L);
        fund3.setCurrentFund(11000L);
        fund3.setExpDate(LocalDate.of(2022, 7, 11));
        fund3.setContent("https://btaeredux.s3.ap-northeast-2.amazonaws.com/%EA%B0%90%EC%9E%90-cutout.png");
        funds.add(fund3);

        Fund fund4 = new Fund();
        fund4.setTitle("[시원함은 IN, 땀과 물은 OUT] 뜨거운 발에 시원함을 선물하세요");
        fund4.setSubTitle("땀과 열기는 빠지고 바닥부터 올라오는 시원함! 열과 땀이 많은 발을 위한 쿨링슈즈. 언제 어디서나 한결같은 쾌적함을 플리즈 “프리즈”");
        fund4.setImageURL("https://img5.yna.co.kr/etc/inner/KR/2020/06/08/AKR20200608115700051_02_i_P4.jpg");
        fund4.setCategory("스포츠·모빌리티");
        fund4.setFundingGoal(990000L);
        fund4.setCurrentFund(1111000L);
        fund4.setExpDate(LocalDate.of(2022, 7, 11));
        fund4.setContent("https://btaeredux.s3.ap-northeast-2.amazonaws.com/%EC%8B%A0%EB%B0%9C-cutout.png");
        funds.add(fund4);

        Fund fund5 = new Fund();
        fund5.setTitle("[방황 그만]아직도 피로 풀어줄 템 찾아? 쑥뜸 한 번이면 해결되는데?");
        fund5.setSubTitle("1차 펀딩으로 증명된 효과! 쑥뜸뜸이는 피로한 부위라면 어디든 만능 해결사가 되어줄 거에요. 유선 & 2구의 한 층 더 강력해진 쑥뜸뜸이로 피로와는 안녕~ 나만의 힐링 시작~!");
        fund5.setImageURL("https://www.earlyadopter.co.kr/wp-content/uploads/2016/01/alex-wearable-posture-tracker-n-coach-2.png");
        fund5.setCategory("테크·가전");
        fund5.setFundingGoal(1000000L);
        fund5.setCurrentFund(111000L);
        fund5.setExpDate(LocalDate.of(2022, 7, 11));
        fund5.setContent("https://btaeredux.s3.ap-northeast-2.amazonaws.com/%EB%A7%88%EC%82%AC%EC%A7%80-cutout.png");
        funds.add(fund5);

        Fund fund6 = new Fund();
        fund6.setTitle("완벽한 겉 방수, 속 쾌적! 비오는 날엔 항상 [포시즌 레인코트&스커트]");
        fund6.setSubTitle("방수 되는데 안 꿉꿉한 레인코트는 처음일 거에요. 심지어 입고 출근해도 우비인지 모를 완벽한 디자인까지. 사계절 내내 우산, 장화보다 더 확실하게 비를 피하는 필수템을 소개합니다.");
        fund6.setImageURL("https://www.fashionbiz.co.kr/images/AT/AR/%EC%95%8C%ED%8C%8C%EC%84%AC%EC%9C%A0600.JPG");
        fund6.setCategory("패션·잡화");
        fund6.setFundingGoal(10000000L);
        fund6.setCurrentFund(111000L);
        fund6.setExpDate(LocalDate.of(2022, 7, 11));
        fund6.setContent("https://btaeredux.s3.ap-northeast-2.amazonaws.com/%EB%B9%84%EC%98%B7-cutout.png");
        funds.add(fund6);

        fundRepository.saveAll(funds);

    }
}
