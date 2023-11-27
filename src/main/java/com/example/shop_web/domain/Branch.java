package com.example.shop_web.domain;

import com.example.shop_web.domain.dto.BranchResDTO;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "branchs")
@Getter
@Setter
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    public BranchResDTO toBranchReqDTO(){
        return new BranchResDTO()
                .setId(id)
                .setBranchName(name);
    }
}
