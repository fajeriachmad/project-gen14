package com.universe.service;

public class AddService {
	public String add(String a, String b) {
		StringBuilder x = new StringBuilder(a);
		StringBuilder y = new StringBuilder(b);
		StringBuilder z = x.append(" ").append(y);
		return z.toString();
	}
}
