/**
 * 
 */
package com.univers.architecture.transporter.service;

import java.util.List;

import com.univers.architecture.transporter.model.TaskExecution;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author sabir
 *
 */
public interface ITaskExecutionService {
	public Page<TaskExecution> getAllTaskExecution(Specification<TaskExecution> spec, Pageable page);
}
