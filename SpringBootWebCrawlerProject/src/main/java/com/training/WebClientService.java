package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.model.Domain;
import com.training.model.DomainList;
import com.training.model.Movie;
import com.training.model.PurchasedBook;
import com.training.model.PurchasedBookListClass;

import reactor.core.publisher.Mono;
import java.util.stream.Collectors;
@Service
public class WebClientService {

	//private KafkaTemplate<String, Domain> kafkaTemplate;
	
	//private final String KAFKA_TOPIC = "web-domains";
	
	@Autowired
	private KafkaTemplate<String, Movie> kafkaTemplateMovie;
	
	private final String KAFKA_TOPIC_MOVIE = "moviedomainsnew";

	
	/*
	 * public WebClientService(KafkaTemplate<String, Domain> kafkaTemplate) {
	 * this.kafkaTemplate = kafkaTemplate; }
	 */
	 
	
	
	public void crawl() {
		Mono<PurchasedBook[]> bookMonoList=WebClient.create()
				.get()
				.uri("http://localhost:8083/bookstore/books")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(PurchasedBook[].class);



		bookMonoList.subscribe(bookArray->Arrays.stream(bookArray).collect(Collectors.toList())
				.forEach(i->System.out.println(i)));	



	}

	public void crawlMovies() {
		Mono<Movie[]> bookMonoList=WebClient.create()
				.get()
				.uri("http://localhost:8083/movies")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Movie[].class);



		bookMonoList.subscribe(movieArray->Arrays.stream(movieArray).collect(Collectors.toList())
				.forEach(movie->{
					kafkaTemplateMovie.send(KAFKA_TOPIC_MOVIE, movie); //moviedomainsnew
					System.out.println(movie);
				}));	



	}

	//https://api.domainsdb.info/v1/domains/search?domain=facebook&zone.com
	public void crawlDomains(String name) {

		Mono<DomainList> domainListMono = WebClient.create()
				.get()
				.uri("https://api.domainsdb.info/v1/domains/search?domain=" + name + "&zone.com")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(DomainList.class);


		domainListMono.subscribe(domainList -> {
			domainList.getDomains()
			.forEach(domain -> {
			//	kafkaTemplate.send(KAFKA_TOPIC, domain);
				System.out.println("Domain Name : " + domain.getDomain());
			});
		});

	}

}
