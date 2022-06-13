package com.assignment.reward.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	private Long userId;

	private String name;

	private LocalDate createdDate;

}
