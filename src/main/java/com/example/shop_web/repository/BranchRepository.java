package com.example.shop_web.repository;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.dto.BranchResDTO;
import com.example.shop_web.domain.dto.ProductResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BranchRepository extends JpaRepository<Branch,Long> {
    @Query("SELECT NEW com.example.shop_web.domain.dto.BranchResDTO ( " +
            "br.id, " +
            "br.name " +
            ") " +
            "FROM Branch AS br "
    )
    List<BranchResDTO> findAllBranchResDTO();
    ;

    Branch findBranchById(Long BranchId);
}
