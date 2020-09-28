
package com.example.actuatorservice;

public class Customer {

  private final long id;
  private final String custName;
  private long amt;
  private  int month;
  private  long reward;
  

  public Customer(long id, String custName, long amt, int month, long reward) {
    this.id = id;
    this.custName = custName;
    this.amt=amt;
    this.month=month;
    this.reward=reward;
  }

  
  public Customer(long id, String custName) {
	    this.id = id;
	    this.custName = custName;
	  }
  
  public long getAmt() {
	return amt;
}

public void setAmt(long amt) {
	this.amt = amt;
}

public int getMonth() {
	return month;
}

public void setMonth(int month) {
	this.month = month;
}

public long getReward() {
	return reward;
}

public void setReward(long reward) {
	this.reward = reward;
}

public long getId() {
    return id;
  }

  public String getCustName() {
    return custName;
  }


}