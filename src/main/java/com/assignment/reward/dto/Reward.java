package com.assignment.reward.dto;

import java.util.List;

import com.assignment.reward.model.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reward {

	private Long userId;

	private List<Transaction> transactions;

	private Long totalRewardPoints;

	private List<Long> lastThreeMonthsPoints;

}
