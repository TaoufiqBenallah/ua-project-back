package com.univers.architecture.transporter.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.univers.architecture.transporter.model.TaskExecution;
import com.univers.architecture.transporter.model.TaskExecutionStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskConfigRepositoryTest {

	@Autowired
	private ITaskExecutionRepository taskExecutionRepository;

	@Test
	public void createTaskExecution() {

		Random r = new Random();

		for (int i = 0; i <70 ; i++) {
			int randDay = r.nextInt((30 -1) + 1)+1;
			int randMonth = r.nextInt((12-1) + 1)+1 ;
			int randYear = r.nextInt((2020- 2000) + 1) + 2000;
			int randHour =  r.nextInt((23 ) + 1) ;
			int randMinute =  r.nextInt((59 ) + 1) ;
			int randSecond =  r.nextInt((59 ) + 1) ;
			LocalDateTime startldt = LocalDateTime.of(randYear, randMonth, randDay, randHour, randMinute, randSecond);
			Date startDate = Date.from(startldt.atZone(ZoneId.systemDefault()).toInstant());
	
			LocalDateTime endldt = LocalDateTime.of(randYear, randMonth, randDay, randHour, randMinute, randSecond);
			Date endDate = Date.from(endldt.atZone(ZoneId.systemDefault()).toInstant());
	
			TaskExecution task1 = new TaskExecution();
			task1.setTaskConfigName("taskConfigName " +i );
	
	
				int rand = r.nextInt(4);
				switch (rand){
					case 0:		task1.setStatus(TaskExecutionStatus.ERROR); break;
					case 1: 	task1.setStatus(TaskExecutionStatus.STARTED);break;
					case 2: 	task1.setStatus(TaskExecutionStatus.SUCCESS);break;
	
				}
			task1.setTransportedFiles("file"+i);
			task1.setStartDate(startDate);
			task1.setMessage("long message");
			task1.setEndDate(endDate);
	
			this.taskExecutionRepository.save(task1);
			assertTrue(task1.getId() != null);

	    }
	 }

}
