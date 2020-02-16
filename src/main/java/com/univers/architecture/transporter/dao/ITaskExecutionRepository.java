/**
 * 
 */
package com.univers.architecture.transporter.dao;
import java.util.List;

import com.univers.architecture.transporter.model.TaskExecution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.univers.architecture.transporter.model.TaskExecution;

/**
 * @author sabir
 *
 */
public interface ITaskExecutionRepository extends PagingAndSortingRepository<TaskExecution, String> , JpaSpecificationExecutor<TaskExecution> {

}