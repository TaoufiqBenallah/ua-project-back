package com.univers.architecture.transporter.service.search;

import com.univers.architecture.transporter.model.TaskExecution;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskExecutionSpecificationsBuilder {
	private final List<SearchCriteria> params;

    public TaskExecutionSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public TaskExecutionSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<TaskExecution> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
                .map(TaskExecutionSpecification::new)
                .collect(Collectors.toList());

        Specification result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i)
                    .getOperation() != null
                    ? Specification.where(result)
                    .or(specs.get(i))
                    : Specification.where(result)
                    .and(specs.get(i));
        }
        return result;
    }
}
