package com.blessing.core.service;

import com.blessing.core.domain.Order;

public interface OrderService {
    Order createOrder(Long memberId, int itemPrice, String itemName);
}
