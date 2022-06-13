package com.assignment.reward.service;

import java.util.List;

import com.assignment.reward.dto.Reward;
import com.assignment.reward.model.Transaction;

public interface IRewardService {

	public Reward getRewardPoints(List<Transaction> transactions);

}
