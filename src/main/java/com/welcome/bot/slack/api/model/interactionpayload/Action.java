package com.welcome.bot.slack.api.model.interactionpayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"action_id",
"block_id",
"text",
"type",
"value",
"action_ts"
})
public class Action {

	@JsonProperty("action_id")
	private String actionId;
	@JsonProperty("block_id")
	private String blockId;
	@JsonProperty("text")
	private Text_ text;
	@JsonProperty("type")
	private String type;
	@JsonProperty("value")
	private String value;
	@JsonProperty("action_ts")
	private String actionTs;
	
	public String getActionId() {
		return actionId;
	}
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	
	public String getBlockId() {
		return blockId;
	}
	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}
	
	public Text_ getText() {
		return text;
	}
	public void setText(Text_ text) {
		this.text = text;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getActionTs() {
		return actionTs;
	}
	public void setActionTs(String actionTs) {
		this.actionTs = actionTs;
	}
}
