package com.assignment.reward.util;

public class RewardUtil {

	public static Long calculateReward(Long amount) {

		Long aboveHundred = amount - 100l > 0 ? amount - 100l : 0l;
		Long aboveFifty = amount - 50l > 0 ? amount - 50l : 0l;

		return (aboveHundred * 2) + aboveFifty;
	}

}
