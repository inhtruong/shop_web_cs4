package com.example.shop_web.service.branch;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.dto.BranchResDTO;
import com.example.shop_web.service.IGeneralService;

import java.util.List;

public interface IBranchService extends IGeneralService<Branch,Long> {
    List<BranchResDTO> findAllBranchResDTO();
    Branch findByBranchId(Long branchId);
}
