package com.ceyentra.sm.dto.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationResDTO<T,S> {
    T reservation;
    Double total;
    List<S> items;
    List<QueryResDTO> queries;
}
