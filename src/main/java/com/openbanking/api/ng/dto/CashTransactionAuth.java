package com.openbanking.api.ng.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CashTransactionAuth implements Serializable{

	private String name;
	
	private String value;
}
