package com.example.actuatorservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/hello-world")
	@ResponseBody
	public String sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {

		Customer[] customerArr;
		customerArr = new Customer[10];

		customerArr[0] = new Customer(0, "CustA", 70, 10, 0);
		customerArr[1] = new Customer(1, "CustA", 160, 10, 0);
		customerArr[2] = new Customer(2, "CustA", 30, 11, 0);
		customerArr[3] = new Customer(3, "CustB", 170, 10, 0);
		customerArr[4] = new Customer(4, "CustB", 60, 10, 0);
		customerArr[5] = new Customer(5, "CustB", 30, 11, 0);

		
		System.out.println("adding reward *********");

		for (int i = 0; i < 6; i++) {

			
			long x = customerArr[i].getAmt() - 50;
			long y = x - 50;
			long z = 0;
			if (x > 0)
				z = x * 1;
			if (y > 0)
				z += y * 1;

			customerArr[i].setReward(z);

			System.out.println("cust name " + customerArr[i].getCustName() + " amt " + customerArr[i].getAmt()
					+ "  reward  " + customerArr[i].getReward());
		}

		totalReward(customerArr);
		return "success";
		//return new Customer(counter.incrementAndGet(), String.format(template, name));
	}

	private void totalReward(Customer[] v_customerArr) {
		String a = "";
		int x = 0;
		long y = 0;
		System.out.println("report*********");
		for (int i = 0; i < 6; i++) {

			if (i == 0) {
				a = v_customerArr[i].getCustName();
				x = v_customerArr[i].getMonth();
				y = 0;
			}

			if (a == v_customerArr[i].getCustName() && x == v_customerArr[i].getMonth()) {
				y = y + v_customerArr[i].getReward();
			} else {

				System.out.println(a + " mnth =" + x + " " + "total rewards = " + y);

				a = v_customerArr[i].getCustName();
				x = v_customerArr[i].getMonth();
				y = v_customerArr[i].getReward();
				// customerArr[i].setReward(z);
			}

			if (i == 5)
				System.out.println(v_customerArr[i].getCustName() + " mnth =" + v_customerArr[i].getMonth() + " "
						+ "total rewards = " + y);

		}
	}

}