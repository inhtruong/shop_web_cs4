package com.example.shop_web.controller.api;

import com.example.shop_web.domain.Cart;
import com.example.shop_web.domain.CartDetail;
import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.User;
import com.example.shop_web.domain.dto.CartDetailCreDTO;
import com.example.shop_web.domain.dto.CartDetailSaveDTO;
import com.example.shop_web.exception.DataInputException;
import com.example.shop_web.repository.CartDetailRepository;
import com.example.shop_web.repository.CartRepository;
import com.example.shop_web.repository.ProductRepository;
import com.example.shop_web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/{idUser}")
    public ResponseEntity<?> getCartByUserId(@PathVariable Long idUser){
            List<CartDetail> cartDetails = cartDetailRepository.getAllByUser_Id(idUser);
        return new ResponseEntity<>(cartDetails, HttpStatus.OK);
    }
    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCard(@RequestBody CartDetailCreDTO cartDetailCreDTO){
//        Optional<User> user = userRepository.findById(cartDetailCreDTO.getIdUser());
        Optional<Cart> cart = cartRepository.findByUserId(cartDetailCreDTO.getIdUser());
        Optional<Product> product = productRepository.findById(cartDetailCreDTO.getIdProduct());
        if(cartDetailRepository.countAllByProductIdAndCart_Id(product.get().getId(), cart.get().getId()) == 0 ){
            int qty = 1;
            BigDecimal totalAmount  = product.get().getPrice().multiply(BigDecimal.valueOf(qty));
            CartDetail cartDetail = new CartDetail().setCart(cart.get()).setQuantity(1).setChecked(false).setProduct(product.get()).setTotalAmount(totalAmount);
            cartDetailRepository.save(cartDetail);
            List<CartDetail> cartDetails = cartDetailRepository.getAllByUser_Id(cartDetailCreDTO.getIdUser());
            return new ResponseEntity<>(cartDetails, HttpStatus.OK);
        }else throw new DataInputException("Product is existing");

    }
    @DeleteMapping("/delete/{idCartDetail}")
    public ResponseEntity<?> deleteCartDetail(@PathVariable Long idCartDetail){
        cartDetailRepository.deleteById(idCartDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/updateCart")
    public ResponseEntity<?> saveCart(@RequestBody CartDetailSaveDTO cartDetailSaveDTO){
            CartDetail cartDetailOld = cartDetailRepository.findById(cartDetailSaveDTO.getId()).get();
            cartDetailOld.setId(cartDetailSaveDTO.getId());
            cartDetailOld.setQuantity(cartDetailSaveDTO.getQuantity());
            cartDetailOld.setTotalAmount(cartDetailOld.getProduct().getPrice().multiply(BigDecimal.valueOf(cartDetailSaveDTO.getQuantity())));
            cartDetailRepository.save(cartDetailOld);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
