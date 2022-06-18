package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.request.FundOrderDetailRequestDto;
import com.example.clone6_backend.dto.request.FundOrderRequestDto;
import com.example.clone6_backend.exceptionHandler.NormalResponse;
import com.example.clone6_backend.model.FundOrder;
import com.example.clone6_backend.model.FundOrderDetail;
import com.example.clone6_backend.repository.FundOrderDetailRepository;
import com.example.clone6_backend.repository.FundOrderRepository;
import com.example.clone6_backend.repository.RewardRepository;
import com.example.clone6_backend.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FundOrderService {

    private final FundOrderRepository fundOrderRepository;

    private final FundOrderDetailRepository fundOrderDetailRepository;

    private final RewardRepository rewardRepository;

    //private final FundRepository fundRepository

    @Transactional
    public ResponseEntity fundOrder(UserDetailsImpl userDetails, Long fundId, FundOrderRequestDto requestDto) {
        int totalFunds = 0;
        FundOrder fundOrder = new FundOrder(userDetails,fundId,requestDto);
        List<FundOrderDetailRequestDto> detailRequestDtoList = requestDto.getOrderedRewards();
        fundOrderRepository.save(fundOrder);
        List<FundOrderDetail> fundOrderDetailList = new ArrayList<>();
        for (FundOrderDetailRequestDto fundOrderDetailRequestDto : detailRequestDtoList) {
            FundOrderDetail fundOrderDetail =
                    new FundOrderDetail(fundOrder.getFundOrderId(), fundOrderDetailRequestDto);
            fundOrderDetailList.add(fundOrderDetail);
            int price = rewardRepository.findByRewardId(fundOrderDetailRequestDto.getRewardId()).getPrice();
            totalFunds += price * fundOrderDetail.getQuantity();
        }
        //Fund fund = fundRepository.findByFundId(fundId).orElseThrow(
        // () -> new CustomException(ErrorCode.FUND_NOT_FOUND));
        //fund.setCurrentFund = fund.getCurrentFund + totalFunds;
        //fundRepository.save(fund);
        fundOrderDetailRepository.saveAll(fundOrderDetailList);
        return  ResponseEntity
                .status(200)
                .body(NormalResponse.builder()
                        .status(200)
                        .message("펀딩내역이 성공적으로 저장되었습니다")
                        .build());
    }
}
