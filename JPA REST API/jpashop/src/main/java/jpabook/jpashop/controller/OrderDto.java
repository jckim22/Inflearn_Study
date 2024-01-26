package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
public class OrderDto {
    private Long memberId;
    private Long itemId;
    private int count;
}
