package uk.co.emcreations.eDJPanel.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class AbstractController {
	@Value("${eDJPanel.locale.country:GB}")
	private String localeCountry;
	
	@Value("${eDJPanel.locale.language:en}")
	private String localeLanguage;

	public final Locale locale;
	
	protected final SimpleDateFormat dateTimeFormat;
	protected final DateFormat localeDateTimeFormat;
	
	@Autowired
	protected ObjectMapper mapper = new ObjectMapper();
	
	public AbstractController() {
		log.info("Locale country = " + this.localeCountry);
		log.info("Locale language = " + this.localeLanguage);
		locale = new Locale("en", "GB");
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
