package com.assignment.reward.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable {

	private Long transactionId;

	private Long amount;

	private LocalDate transactionDate;

}
