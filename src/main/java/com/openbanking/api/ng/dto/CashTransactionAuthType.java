package com.openbanking.api.ng.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashTransactionAuthType implements Serializable {


	private String name;
	
	private String type;
	
	private String description;
}
