package com.welcome.bot.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.welcome.bot.services.SlackApiEventListener;
import com.welcome.bot.services.SlackService;
import com.welcome.bot.slack.api.model.interactionpayload.Channel;

@RestController
public class ChannelsController {
	
	@Autowired
	SlackService slackService;
	
	//get list of channels when creating schedule
	@GetMapping("/api/channels")
	public List<Channel> getChannelsList() {
		//ne radi dok se ne poveze sa slackom
	    return slackService.getChannelsList();
	}
	
}
