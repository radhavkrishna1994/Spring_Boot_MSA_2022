package com.training.batch;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.training.config.SpringBatchConfig;
import com.training.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {
	Logger log = LoggerFactory.getLogger(SpringBatchConfig.class);
	
    private static final Map<String, String> DEPT_NAMES =
            new HashMap<>();

    public Processor() {
        DEPT_NAMES.put("001", "Technology");
        DEPT_NAMES.put("002", "Operations");
        DEPT_NAMES.put("003", "Accounts");
    }

    @Override
    public User process(User user) throws Exception {
    	log.info("Processing.....");
    	//Thread.sleep(5000);
        String deptCode = user.getDept();
        String dept = DEPT_NAMES.get(deptCode);
        user.setName(user.getName().toUpperCase());
        user.setDept(dept);
        user.setTime(LocalDateTime.now());
        System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
        return user;
    }
}
