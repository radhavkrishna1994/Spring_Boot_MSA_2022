package com.training.model;

//https://api.domainsdb.info/v1/domains/search?domain=facebook&zone.com
import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Domain implements Serializable  {

	/*
	 * String domain; String create_date; String update_date; String country;
	 * boolean isDead;
	 */
  
  String domain;
  String create_date;
  String update_date;
  String country;
  boolean isDead;
	/*
	 * String A; String NS; String CNAME; String MX; String TXT;
	 */
  
  
}