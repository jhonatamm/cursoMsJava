package com.medinastech.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.medinastech.hrpayroll.entities.Payment;
import com.medinastech.hrpayroll.entities.Worker;
import com.medinastech.hrpayroll.feignclients.WorkerFeignClient;

//@Component
@Service
public class PaymentService {
	
	/*
	 * @Value("${hr-worker.host}") private String workerHost;
	 * 
	 * @Autowired private RestTemplate restTemplate;
	 * 
	 * public Payment getPayment(long workerId, int days) { Map<String,String>
	 * urlVariables = new HashMap<>(); urlVariables.put("id", ""+workerId);
	 * 
	 * Worker worker = restTemplate.getForObject(workerHost +"/workers/{id}",
	 * Worker.class,urlVariables); return new Payment(worker.getName(),
	 * worker.getDailyIncome(), days); }
	 */
	@Autowired 
	private WorkerFeignClient feignClient;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = feignClient.findById(workerId).getBody();
		return new Payment(worker.getName(),
				  worker.getDailyIncome(), days);
	}
	
}
