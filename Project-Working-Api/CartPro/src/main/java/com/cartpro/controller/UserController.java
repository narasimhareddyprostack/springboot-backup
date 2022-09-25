package com.cartpro.controller;


import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartpro.jwt.JwtTokenProvider;
import com.cartpro.model.Product;
import com.cartpro.model.Role;
import com.cartpro.model.Transaction;
import com.cartpro.model.User;
import com.cartpro.service.ProductService;
import com.cartpro.service.TransactionService;
import com.cartpro.service.UserService;

@RestController
public class UserController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user){
    	System.out.println(user.getName());
        if(userService.findByUsername(user.getUsername())!=null){
            return new ResponseEntity<String>("User Name IS Null ",HttpStatus.CONFLICT);
        }
		//default role.
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/login")
    public ResponseEntity<?> getUser(Principal principal){
    	//principal = httpServletRequest.getUserPrincipal.
    	System.out.println(""+ principal);
        if(principal ==null){
        	System.out.println("Logout");
            //logout will also use here so we should return ok http status.
            return ResponseEntity.ok(principal);
        }
      
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) principal;
        System.out.println("token"+ authenticationToken);
        User user = userService.findByUsername(authenticationToken.getName());
        user.setToken(tokenProvider.generateToken(authenticationToken));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
  
    @PostMapping("/api/purchase")
    public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction){
        System.out.println("purchase");
        transaction.setPurchaseDate(LocalDateTime.now());
         transactionService.saveTransaction(transaction);
         return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
    
    
    	@PostMapping("/api/user/products")
    	public ResponseEntity<String> Saveproducts(@RequestBody Product product){
    		ResponseEntity< String> resp =null;
    		try {
				  Product id= productService.saveProduct(product);
				  String message= "Product is saved "+ id;
				  resp = new ResponseEntity<String>(message, HttpStatus.CREATED);
			} catch (Exception e) {
				resp= new ResponseEntity<String>("Unable to store the Data", HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}    		
    		return resp;
    	}
    @GetMapping("/api/user/allproducts")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }
    
    
    @GetMapping("/api/user/allusers")
    public ResponseEntity<String> getAllUsers(){
    	ResponseEntity<String> resp= null;
    	try {
			List<User> list=userService.findAllUsers();
			   String message= "get All user Data"+ list;
			resp= new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp= new ResponseEntity<String>("Data Not Found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	return resp;
    }
    
}