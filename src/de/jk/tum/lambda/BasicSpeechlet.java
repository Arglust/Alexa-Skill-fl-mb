package de.jk.tum.lambda;

import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.OutputSpeech;
import com.amazon.speech.ui.PlainTextOutputSpeech;

public class BasicSpeechlet implements Speechlet {

	public SpeechletResponse onIntent(IntentRequest arg0, Session arg1) throws SpeechletException {
		PlainTextOutputSpeech returnValue = new PlainTextOutputSpeech();
		returnValue.setText("return value");
		return SpeechletResponse.newTellResponse(returnValue);
	}

	public SpeechletResponse onLaunch(LaunchRequest arg0, Session arg1) throws SpeechletException {
		
		PlainTextOutputSpeech returnValue = new PlainTextOutputSpeech();
		returnValue.setText("return value");
		return SpeechletResponse.newTellResponse(returnValue);
	}

	public void onSessionEnded(SessionEndedRequest arg0, Session arg1) throws SpeechletException {
		// TODO Auto-generated method stub
		
	}

	public void onSessionStarted(SessionStartedRequest arg0, Session arg1) throws SpeechletException {
		// TODO Auto-generated method stub
		
	}

}
