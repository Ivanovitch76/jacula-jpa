package be.steformations.it.jacula.dao.work;

import java.io.Serializable;

public class JmsMessage implements Serializable{

	private static final long serialVersionUID = -634657239604680955L;
	
	private int jobId;
	private int clientId;

	public int getJobId() {
		return jobId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
}
