package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.web.request.MealOrderReqDTO;
import com.ceyentra.sm.dto.web.request.ReservationApproveReqDTO;
import com.ceyentra.sm.dto.web.request.TableReservationReqDTO;
import com.ceyentra.sm.dto.web.response.TableReservationResDTO;
import com.ceyentra.sm.enums.MealOperationalStatus;
import com.ceyentra.sm.enums.QueryType;

public interface ReservationService {

    TableReservationResDTO saveTableReservation(TableReservationReqDTO reqDTO);

    void saveMealOrder(MealOrderReqDTO mealOrderDTO);

    Object getReservationsByType(QueryType type, Long id);

    Object getReservationsByTypeAndId(QueryType type, Long id);

    Object getAllReservations(QueryType type);

    void updateReservationOperationalStatus(Long id, ReservationApproveReqDTO reqDTO);
}
