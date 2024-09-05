package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.web.request.MealOrderReqDTO;
import com.ceyentra.sm.dto.web.request.ReservationApproveReqDTO;
import com.ceyentra.sm.dto.web.request.TableReservationReqDTO;
import com.ceyentra.sm.dto.web.response.OrderPaymentSessionResDTO;
import com.ceyentra.sm.dto.web.response.TableReservationResDTO;
import com.ceyentra.sm.entity.MealOrderDetail;
import com.ceyentra.sm.enums.QueryType;
import com.stripe.exception.StripeException;

import java.util.List;

public interface ReservationService {

    TableReservationResDTO saveTableReservation(TableReservationReqDTO reqDTO);

    OrderPaymentSessionResDTO saveMealOrder(MealOrderReqDTO mealOrderDTO);

    Object getReservationsByType(QueryType type, Long id);

    Object getReservationsByTypeAndId(QueryType type, Long id);

    Object getAllReservations(QueryType type);

    void updateReservationOperationalStatus(Long id, ReservationApproveReqDTO reqDTO);

    String generatePaymentSessionLinkMealOrder(List<MealOrderDetail> mealOrderDetails) throws StripeException;
}
