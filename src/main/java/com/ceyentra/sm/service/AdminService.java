package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.web.request.SaveAdminReqDTO;

import java.util.List;

public interface AdminService {

    void saveAdmin(SaveAdminReqDTO adminReqDTO);

    List<Object> getAllAdminPortalUsers();
}
