package com.assignment.reward.service.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assignment.reward.dto.Reward;
import com.assignment.reward.model.Transaction;
import com.assignment.reward.service.IRewardService;
import com.assignment.reward.util.RewardUtil;

@Service
public class RewardServiceImpl implements IRewardService {

	@Override
	public Reward getRewardPoints(List<Transaction> transactions) {

		Long firstMonthPoints = 0l;
		Long secondMonthPoints = 0l;
		Long thirdMonthPoints = 0l;
		Long totalPoints = 0l;
		Reward reward = new Reward();

		LocalDate today = LocalDate.now();

		LocalDate firstMonth = today.minusMonths(3);
		LocalDate secondMonth = today.minusMonths(2);
		LocalDate thirdMonth = today.minusMonths(1);

		List<Transaction> firstMonthTransactions = transactions.stream()
				.filter(t -> t.getTransactionDate().isAfter(thirdMonth) && t.getTransactionDate().isBefore(secondMonth))
				.collect(Collectors.toList());

		List<Transaction> secondMonthTransactions = transactions.stream()
				.filter(t -> t.getTransactionDate().isAfter(secondMonth) && t.getTransactionDate().isBefore(firstMonth))
				.collect(Collectors.toList());

		List<Transaction> lastMonthTransactions = transactions.stream()
				.filter(t -> t.getTransactionDate().isAfter(firstMonth) && t.getTransactionDate().isBefore(today))
				.collect(Collectors.toList());

		for (Transaction transaction : firstMonthTransactions) {
			Long rewardPoints = RewardUtil.calculateReward(transaction.getAmount());
			firstMonthPoints += rewardPoints;
			totalPoints += rewardPoints;
		}

		for (Transaction transaction : secondMonthTransactions) {
			Long rewardPoints = RewardUtil.calculateReward(transaction.getAmount());
			secondMonthPoints += rewardPoints;
			totalPoints += rewardPoints;
		}

		for (Transaction transaction : lastMonthTransactions) {
			Long rewardPoints = RewardUtil.calculateReward(transaction.getAmount());
			thirdMonthPoints += rewardPoints;
			totalPoints += rewardPoints;
		}

		reward.setTransactions(transactions);
		reward.setTotalRewardPoints(totalPoints);
		reward.setLastThreeMonthsPoints(Arrays.asList(firstMonthPoints, secondMonthPoints, thirdMonthPoints));

		return reward;
	}

}
