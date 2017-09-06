package de.jk.tum.lambda;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public class BasicEndPointHandler extends SpeechletRequestStreamHandler {

	public BasicEndPointHandler() {
		super(new BasicSpeechlet(), supportedApplicationIds);
		
	}

	private static final Set<String> supportedApplicationIds = new HashSet<String>();
	static {
		/*
		 * This Id can be found on https://developer.amazon.com/edw/home.html#/
		 * "Edit" the relevant Alexa Skill and put the relevant Application Ids
		 * in this Set.
		 */
		//supportedApplicationIds.add("amzn1.echo-sdk-ams.app.amzn1.ask.skill.[]");
	}

}
