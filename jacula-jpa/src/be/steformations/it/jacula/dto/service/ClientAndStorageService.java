package be.steformations.it.jacula.dto.service;

import be.steformations.it.jacula.dto.beans.Job;

public interface ClientAndStorageService {

	void saveBackup(int clientId, int jobId, String filePath, byte[] fileContent) throws Exception;
	byte[] getBackup(Integer clientId, Integer jobId, String filePath) throws Exception;
	Job getJob(Integer jobId);
	
}
