package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.request.FundOrderDetailRequestDto;
import com.example.clone6_backend.dto.request.FundOrderRequestDto;
import com.example.clone6_backend.model.FundOrder;
import com.example.clone6_backend.model.FundOrderDetail;
import com.example.clone6_backend.repository.FundOrderDetailRepository;
import com.example.clone6_backend.repository.FundOrderRepository;
import com.example.clone6_backend.repository.UserRepository;
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

    @Transactional
    public ResponseEntity fundOrder(UserDetailsImpl userDetails, Long fundId, FundOrderRequestDto requestDto) {
        int totalfunds = 0;
        FundOrder fundOrder = new FundOrder(userDetails,fundId,requestDto);
        List<FundOrderDetailRequestDto> detailRequestDtoList = requestDto.getOrderedRewards();
        fundOrderRepository.save(fundOrder);
        List<FundOrderDetail> fundOrderDetailList = new ArrayList<>();
        for (int i = 0; i < detailRequestDtoList.size(); i++) {
            FundOrderDetail fundOrderDetail =
                    new FundOrderDetail(fundOrder.getFundOrderId(),detailRequestDtoList.get(i));
            fundOrderDetailList.add(fundOrderDetail);

        }
        return null;
    }
}
