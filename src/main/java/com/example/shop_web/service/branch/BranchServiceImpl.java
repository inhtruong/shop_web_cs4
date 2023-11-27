package com.example.shop_web.service.branch;

import com.example.shop_web.domain.Branch;

import com.example.shop_web.domain.dto.BranchResDTO;
import com.example.shop_web.repository.BranchRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class BranchServiceImpl implements  IBranchService {

    @Autowired
    private BranchRepository branchRepository;
    @Override
    public List<Branch> findAll() {
        return null;
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }


    @Override
    public void update(Branch branch) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<BranchResDTO> findAllBranchResDTO() {
        return branchRepository.findAllBranchResDTO();
    }

    @Override
    public Branch findByBranchId(Long branchId) {
        return branchRepository.findBranchById(branchId);
    }
}
