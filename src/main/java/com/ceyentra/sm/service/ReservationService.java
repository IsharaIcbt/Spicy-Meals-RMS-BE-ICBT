package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.web.request.TableReservationReqDTO;
import com.ceyentra.sm.dto.web.response.TableReservationResDTO;

public interface ReservationService {

    TableReservationResDTO saveTableReservation(TableReservationReqDTO reqDTO);

}
