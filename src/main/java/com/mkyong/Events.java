package com.mkyong;

public class Events {

	public String id;
	public String muid;
	public String machineName;
	public String timeStamp;
	public String clientId;
	public String clientName;
	public String huntingRule;
	
	public int status;
	public String alertDateTime;
	public int lastHourEvidenceCount;
	public int severity;
	public String mitre;
	public String alertLink;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMuid() {
		return muid;
	}
	public void setMuid(String muid) {
		this.muid = muid;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getHuntingRule() {
		return huntingRule;
	}
	public void setHuntingRule(String huntingRule) {
		this.huntingRule = huntingRule;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAlertDateTime() {
		return alertDateTime;
	}
	public void setAlertDateTime(String alertDateTime) {
		this.alertDateTime = alertDateTime;
	}
	public int getLastHourEvidenceCount() {
		return lastHourEvidenceCount;
	}
	public void setLastHourEvidenceCount(int lastHourEvidenceCount) {
		this.lastHourEvidenceCount = lastHourEvidenceCount;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public String getMitre() {
		return mitre;
	}
	public void setMitre(String mitre) {
		this.mitre = mitre;
	}
	public String getAlertLink() {
		return alertLink;
	}
	public void setAlertLink(String alertLink) {
		this.alertLink = alertLink;
	}
	public Events() {
		super();
	}
	
	
	
}
