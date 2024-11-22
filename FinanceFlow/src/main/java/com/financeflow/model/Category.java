package com.financeflow.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Category {
	SALARY,
	MEAL_VOUCHER,
	INVESTIMENT,
	SIDE_INCOME
}
