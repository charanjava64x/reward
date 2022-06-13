package com.assignment.reward.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.reward.dto.Reward;
import com.assignment.reward.model.Transaction;
import com.assignment.reward.service.IRewardService;

@RestController
@RequestMapping("/reward")
public class RewardController {

	@Autowired
	private IRewardService rewardService;

	@PostMapping
	public ResponseEntity<Reward> getRewardPoints(@RequestBody List<Transaction> transactions) {

		if (transactions == null || transactions.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		Reward reward = rewardService.getRewardPoints(transactions);

		return new ResponseEntity<>(reward, HttpStatus.OK);
	}

}
