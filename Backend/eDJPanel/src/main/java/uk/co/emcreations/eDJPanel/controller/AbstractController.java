package uk.co.emcreations.eDJPanel.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public abstract class AbstractController {
	@Value("${eDJPanel.locale.country:GB}")
	private String localeCountry;
	
	@Value("${eDJPanel.locale.language:en}")
	private String localeLanguage;

	private Locale locale;
	
	protected SimpleDateFormat dateTimeFormat;
	protected DateFormat localeDateTimeFormat;
	
	@Autowired
	protected ObjectMapper mapper = new ObjectMapper();

	@PostConstruct
	private void postConstruct() {
		log.info("postConstruct called.");
		locale = new Locale(this.localeLanguage, this.localeCountry);
		String dateTimePattern = "hh:mm:ss dd-MM-yyyy";
		dateTimeFormat = new SimpleDateFormat(dateTimePattern);
		localeDateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.DEFAULT, locale);
	}
	
	protected ObjectNode createResponseObject(String value) {
		ObjectNode responseObject = mapper.createObjectNode();
		
	    responseObject.put("value", value);
		
		return responseObject;
	}
}
