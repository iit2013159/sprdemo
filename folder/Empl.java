package com.javalearning.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Empl implements Emp, InitializingBean, DisposableBean {
	private int empid;
	private String name;
	private int basic;
	private float da;
	private float hra;
	private float pf;
	private float salary;
	
	public Empl() {
		super();
	}

	
	public Empl(int empid, String name, int basic, float da, float hra, float pf) {
		super();
		this.empid = empid;
		this.name = name;
		this.basic = basic;
		this.da = da;
		this.hra = hra;
		this.pf = pf;
	}


	@Override
	public void destroy() throws Exception {
		this.name = null;
		System.out.println("Resources released");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.empid = 10;
		this.name = "Bhalchandra";
		this.basic = 80000;
		this.da = 20000;
		this.hra = 10000;
		this.pf = 5000;
		this.salary = this.basic + this.da + this.hra - this.pf;
		System.out.println("Resources initialized");

	}

	@Override
	public void calculateSalary() {
		salary = basic + da + hra - pf;
	}
}