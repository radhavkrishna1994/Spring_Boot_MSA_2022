package com.abcbank.interfaces;


//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abcbank.bean.Account;



//@FeignClient(name="bankservice")//,url="localhost:8081")
//@RibbonClient(name="ribbonclient")
public interface MyFeignClient {
	
	@GetMapping("/getaccount/accountno/{accountno}")
	public Account getAccount(@PathVariable("accountno") long accountno);

}
