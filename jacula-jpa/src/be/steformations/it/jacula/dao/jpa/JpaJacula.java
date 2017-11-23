package be.steformations.it.jacula.dao.jpa;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.NoResultException;

import be.steformations.it.jacula.dao.beans.ClientEntity;
import be.steformations.it.jacula.dao.beans.FileEntity;
import be.steformations.it.jacula.dao.beans.FilesetEntity;
import be.steformations.it.jacula.dao.beans.HistoryEntity;
import be.steformations.it.jacula.dao.beans.JobEntity;
import be.steformations.it.jacula.dao.beans.ScheduleEntity;
import be.steformations.it.jacula.dao.beans.StatutEntity;
import be.steformations.it.jacula.dto.beans.File;
import be.steformations.it.jacula.dto.beans.Job;
import be.steformations.it.jacula.dto.service.DirectorService;

public class JpaJacula implements DirectorService{

	protected javax.persistence.EntityManager em;

	public JpaJacula(javax.persistence.EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public ClientEntity createClient(String ip, String email){
		System.out.println("JpaJacula.createClient()");
		ClientEntity client = null;
		if (ip != null && email != null){
			client = new ClientEntity();
			client.setIpAdress(ip);
			client.setEmail(email);
			if (this.em.isJoinedToTransaction()){
				this.em.persist(client);
				this.em.flush();
			} else {
				this.em.getTransaction().begin();
				this.em.persist(client);
				this.em.getTransaction().commit();
			}
		}
		return client;
	}
	@Override
	public FileEntity createFile(String path){
		System.out.println("JpaJacula.createFile()");
		FileEntity file = null;
		if (path != null){
			file = new FileEntity();
			file.setPath(path);
			if (this.em.isJoinedToTransaction()){
				this.em.persist(file);
				this.em.flush();
			} else {
				this.em.getTransaction().begin();
				this.em.persist(file);
				this.em.getTransaction().commit();
			}
		}
		return file;
	}
	@Override
	public FilesetEntity createFileset(String description, int clientId, java.util.List<Integer> fileId){
		System.out.println("JpaJacula.createFileset()");
		FilesetEntity fileset = null;
		if (description != null){
			try{
				fileset = new FilesetEntity();
				fileset.setDescription(description);
				ClientEntity client = this.em.find(ClientEntity.class, clientId);
				fileset.setClient(client);	
				java.util.List<FileEntity> files = new ArrayList<FileEntity>();
				System.out.println("JpaJacula.createFileset() before loop");
				for (Integer integ : fileId) {
					System.out.println("JpaJacula.createFileset() => integ= " + integ);
					FileEntity entity = this.em.find(FileEntity.class, integ);	
					files.add(entity);
				}
				System.out.println("JpaJacula.createFileset() => files= " + files);
				fileset.setFiles(files);
				if (this.em.isJoinedToTransaction()){
					this.em.persist(fileset);
					this.em.flush();
				} else {
					this.em.getTransaction().begin();
					this.em.persist(fileset);
					this.em.getTransaction().commit();
				}
			} catch (NoResultException e){
				e.printStackTrace();
			}
		}
		return fileset;
	}
	@Override
	public HistoryEntity createHistoryJob(int jobId, Date start, int status){
		System.out.println("JpaJacula.createHistoryJob()");
		HistoryEntity history = null;
		if (this.getStatusById(status) != null){
			try{
				JobEntity job = this.em.find(JobEntity.class, jobId);
				history = new HistoryEntity(job, start, status);
				if (this.em.isJoinedToTransaction()){
					this.em.persist(history);
					this.em.flush();
				} else {
					this.em.getTransaction().begin();
					this.em.persist(history);
					this.em.getTransaction().commit();
				}
			} catch(NoResultException e){
				e.printStackTrace();
			}
		}
		return history;
	}
//	@Override
//	public HistoryEntity createHistoryJobString(int jobId, String start, boolean status) {
//		System.out.println("JpaJacula.createHistoryJobString()");
//		HistoryEntity history = null;
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date timestamp = new Date();
//		try{
//			timestamp = format.parse(start);
//			history = createHistoryJob(jobId, timestamp, status);
//		} catch (java.text.ParseException e) {
//
//			e.printStackTrace();
//		}
//		return history;
//	}
	@Override
	public JobEntity createJob(int filesetId, String type, int scheduleId){
		System.out.println("JpaJacula.createJob()");
		JobEntity job = null;
		try{
			FilesetEntity fileset = this.em.find(FilesetEntity.class, filesetId);
			ScheduleEntity schedule = this.em.find(ScheduleEntity.class, scheduleId);
			job = new JobEntity(fileset, type.toUpperCase(), schedule);
			System.out.println("JpaJacula.createJob() => type= " + type);
			if (this.em.isJoinedToTransaction()){
				this.em.persist(job);
				this.em.flush();
			} else {
				this.em.getTransaction().begin();
				this.em.persist(job);
				this.em.getTransaction().commit();
			}
		} catch(NoResultException e){
			e.printStackTrace();
		}
		return job;
	}
	@Override
	public ScheduleEntity createSchedule(Date start, Integer repeat){
		System.out.println("JpaJacula.createSchedule()");
		ScheduleEntity schedule = null;
		if (start != null){
			schedule = new ScheduleEntity();
			schedule.setStart(start);
			schedule .setRepeat(repeat);
			if (this.em.isJoinedToTransaction()){
				this.em.persist(schedule);
				this.em.flush();
			} else {
				this.em.getTransaction().begin();
				this.em.persist(schedule);
				this.em.getTransaction().commit();
			}
		}
		return schedule;
	}
	
	public StatutEntity getStatusById(int id){
		System.out.println("JpaJacula.getStatusById()");
		StatutEntity statut = null;
		if (id > 0){
			statut = this.em.find(StatutEntity.class, id);
		}
		return statut;
	}

	@Override
	public JobEntity getJobById(int jobId) {
		System.out.println("JpaJacula.getJobById()");
		JobEntity job = null;
		if (jobId > 0){
			job = this.em.find(JobEntity.class, jobId);
		}
		return job;
	}

}
