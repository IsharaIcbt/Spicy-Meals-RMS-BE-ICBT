package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.web.request.SaveQueryReqDTO;
import com.ceyentra.sm.dto.web.response.QueryResDTO;
import com.ceyentra.sm.enums.QueryType;

import java.util.List;

public interface QueryService {

    void save(SaveQueryReqDTO saveQueryReqDTO);

    List<QueryResDTO> getQueries(QueryType type, Long id);
}
