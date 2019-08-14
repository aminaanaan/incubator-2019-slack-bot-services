package com.welcome.bot.slack.api.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionGenerator {
	
<<<<<<< Updated upstream

	static final String TOKEN_BOT = "#";
	static final String TOKEN_USER = "#";

=======
	static final String TOKEN_BOT = "xoxb-692746321984-692302263812-tZIr890TPcT4NVQMlVQA5UqR";
	static final String TOKEN_USER = "xoxp-692746321984-692279219956-720926400772-f8536c16a720c9039868f797408ca2ef";
>>>>>>> Stashed changes

	public ConnectionGenerator() {}
	
	public HttpURLConnection getPostMsgConnection() throws IOException {
		URL url = new URL("https://slack.com/api/chat.postMessage");
		return generatePOSTConnection(url, TOKEN_BOT);
	}
	
	public HttpURLConnection getPrivateMsgConnection() throws IOException {
		URL url = new URL("https://slack.com/api/chat.postEphemeral");
		return generatePOSTConnection(url, TOKEN_BOT);
	}
	
	public HttpURLConnection getScheduleMsgConnection() throws IOException {
		URL url = new URL("https://slack.com/api/chat.scheduleMessage");
		return generatePOSTConnection(url, TOKEN_BOT);
	}
	
	public HttpURLConnection getDeleteScheduledMsgConnection() throws IOException {
		URL url = new URL("https://slack.com/api/chat.deleteScheduledMessage");
		return generatePOSTConnection(url, TOKEN_BOT);
	}
	
	public HttpURLConnection getChannelsListConnection() throws IOException {
		URL url = new URL("https://slack.com/api/conversations.list");
		return generateGETConnection(url, TOKEN_BOT);
	}
	
	public HttpURLConnection getSchedulesListConnection() throws IOException {
		URL url = new URL("https://slack.com/api/chat.scheduledMessages.list");
		return generatePOSTConnection(url, TOKEN_BOT);
	}
	
<<<<<<< Updated upstream
	// for response to interaction
	public HttpURLConnection getInteractionResponseConnection(String responseURL) throws IOException {
		URL url = new URL(responseURL);
=======
	public HttpURLConnection getMessageUpdateConnection() throws IOException {
		URL url = new URL("https://slack.com/api/chat.update");
		return generatePOSTConnection(url, TOKEN_BOT);
	}
	
	public HttpURLConnection getMessageDeleteConnection() throws IOException {
		URL url = new URL("https://slack.com/api/chat.delete");
>>>>>>> Stashed changes
		return generatePOSTConnection(url, TOKEN_BOT);
	}
	
	private HttpURLConnection generatePOSTConnection(URL url, String token) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-type", "application/json");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Authorization", "Bearer " + token); // not needed for interaction response
		connection.setDoOutput(true);
		return connection;
	}
	
	private HttpURLConnection generateGETConnection(URL url, String token) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-type", "application/json");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Authorization", "Bearer " + token);
		return connection;
	}
}