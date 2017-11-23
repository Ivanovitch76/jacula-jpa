package be.steformations.it.jacula.dto.service;

import java.util.Date;
import java.util.List;

import be.steformations.it.jacula.dto.beans.Client;
import be.steformations.it.jacula.dto.beans.File;
import be.steformations.it.jacula.dto.beans.Fileset;
import be.steformations.it.jacula.dto.beans.History;
import be.steformations.it.jacula.dto.beans.Job;
import be.steformations.it.jacula.dto.beans.Schedule;

@javax.jws.WebService
public interface DirectorService {
	
	Client createClient(String ip, String email);
	File createFile(String path);
	Fileset createFileset(String description, int clientId, java.util.List<Integer> fileId);
	History createHistoryJob(int jobId, Date start, int status);
	Job getJobById(int jobId);
	Job createJob(int filesetId, String type, int scheduleId);
	Schedule createSchedule(Date start, Integer repeat);

	
}
