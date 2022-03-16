package com.training.processor;


import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.PurchasedBook;
import com.training.model.Domain;
import com.training.model.Movie;

import java.util.function.Function;

@Configuration
public class BookKafkaProcessor {

  @Bean
  public Function<KStream<String, Movie>, KStream<String, Movie>> movieProcessor() {

    return kstream -> kstream.filter((key, movie) -> {
      if (movie.getGenre().equalsIgnoreCase("thriller")) {
        System.out.println("Movie Details: " + movie.getTitle());
      } 
      return movie.getGenre().equalsIgnoreCase("thriller");
    });

  }
  
	/*
	 * @Bean public Function<KStream<String, Domain>, KStream<String, Domain>>
	 * domainProcessor() {
	 * 
	 * return kstream -> kstream.filter((key, domain) -> { if (domain.isDead()) {
	 * System.out.println("Inactive Domain: " + domain.getDomain()); } else {
	 * System.out.println("Active Domain: " + domain.getDomain()); } return
	 * !domain.isDead(); });
	 * 
	 * }
	 */
}
