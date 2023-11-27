package com.example.shop_web.controller.api;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.dto.BranchCreReqDTO;
import com.example.shop_web.domain.dto.BranchResDTO;
import com.example.shop_web.domain.dto.ProductCreReqDTO;
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.service.branch.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branchs")
public class BranchRestController {

    @Autowired
    private IBranchService branchService;
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<BranchResDTO> branchs = branchService.findAllBranchResDTO();
        return new ResponseEntity<>(branchs, HttpStatus.OK);
    }
    @GetMapping("/{idBranch}")
    public ResponseEntity<?> findById(@PathVariable Long idBranch) {
        Branch  branch = branchService.findByBranchId(idBranch);
        return new ResponseEntity<>(branch.toBranchReqDTO(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody BranchCreReqDTO branchCreReqDTO, BindingResult bindingResult) {
        new BranchCreReqDTO().validate(branchCreReqDTO, bindingResult);
        Branch branch = new Branch();
        branch.setName(branchCreReqDTO.getBranchName());
        branchService.save(branch);
        return new ResponseEntity<>(branch.toBranchReqDTO(), HttpStatus.CREATED);
    }
    @PatchMapping("/{idBranch}")
    public ResponseEntity<?> update(@Validated @RequestBody BranchCreReqDTO branchCreReqDTO, @PathVariable Long idBranch, BindingResult bindingResult) {
        new BranchCreReqDTO().validate(branchCreReqDTO, bindingResult);
        Branch branch = new Branch();
        branch.setName(branchCreReqDTO.getBranchName());
        branch.setId(idBranch);
        branchService.save(branch);
        return new ResponseEntity<>(branch.toBranchReqDTO(), HttpStatus.OK);
    }
}
