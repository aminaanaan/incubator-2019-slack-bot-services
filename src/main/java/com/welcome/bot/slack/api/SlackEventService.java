package com.welcome.bot.slack.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.welcome.bot.slack.api.model.eventpayload.EventPayload;
import com.welcome.bot.slack.api.model.publishevent.PublishEventMessage;

@Component
public class SlackEventService {
	
	@Autowired
    private ApplicationEventPublisher appEventPublisher;
	
	public String handleEvent(EventPayload event) {
		if(event.getType().equals("event_callback")) {
			String user = event.getEventItem().getUser();
			// ALWAYS CHECK FOR EVENT_TYPE ... DIFFERENT PAYLOADS ARRIVE ON DIFFERENT EVENTS -> -> -> channel-STRING || channel-OBJECT - TODO - TEST/DELETE
			String channel = event.getEventItem().getChannelId();
			
			EventType eventType = null;
			switch(event.getEventItem().getType()) {
			case "app_mention":
				System.out.println("app_mention");
				eventType = EventType.app_mention;
				break;
			case "member_joined_channel":
				System.out.println("member_joined_channel");
				eventType = EventType.member_joined_channel;
				break;
			case "member_left_channel":
				System.out.println("member_left_channel");
				eventType = EventType.member_left_channel;
				break;
			case "channel_created":
				System.out.println("channel_created");
				eventType = EventType.channel_created;
				break;
			case "channel_deleted":
				System.out.println("channel_deleted");
				eventType = EventType.channel_deleted;
				break;
			case "channel_rename":
				System.out.println("channel_rename");
				eventType = EventType.channel_rename;
				break;
			case "channel_archive":
				System.out.println("channel_archive");
				eventType = EventType.channel_archive;
				break;
			case "channel_unarchive":
				System.out.println("channel_unarchive");
				eventType = EventType.channel_unarchive;
				break;
			}
			passEvent(channel, eventType, user);
		}
		else if(event.getType().equals("url_verification")) {
			return event.getChallenge();
		}
		return null;
	}

	private void passEvent(String channel, EventType eventType, String user) {
		PublishEventMessage eventData = new PublishEventMessage();
		eventData.setChannel(channel);
		eventData.setEventType(eventType);
		eventData.setUser(user);
		
		SlackEventTriggeredEvent eventHandler = new SlackEventTriggeredEvent(this, eventData);
		appEventPublisher.publishEvent(eventHandler);
	}
}