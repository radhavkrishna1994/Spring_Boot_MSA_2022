package com.training.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchasedBookListClass implements Serializable
	{
		private List<PurchasedBook> books;

		
	}