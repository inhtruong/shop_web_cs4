package com.example.shop_web.repository;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail,Long> {
    List<CartDetail> getAllByCart_Id(Long cart_id);
    Integer countAllByProductIdAndCart_Id(Long productId, Long cardId);
    @Query(value = "Select cd.* " +
            "from cart_details as cd  " +
            "join (Select c.id " +
            "FROM users as u join carts as c " +
            "on c.user_id = u.id and u.id = :customerId) " +
            "as tb on cd.cart_id = tb.id", nativeQuery=true)
    List<CartDetail> getAllByUser_Id(@Param("customerId") Long customerId);
}
