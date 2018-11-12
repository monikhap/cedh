package com.stg.cedh.maritz.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.stg.cedh.maritz.dto.CustomerSurveyDTO;
import com.stg.cedh.maritz.dto.CustomerSurveyDTO;

@Component
public class CustomerSurveyJobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(CustomerSurveyJobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public CustomerSurveyJobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("============ JOB FINISHED ============ Verifying the results....\n");

			/*List<CustomerSurveyDTO> results = jdbcTemplate.query("SELECT * from customer_Survey", new RowMapper<CustomerSurveyDTO>() {
				@Override
				public CustomerSurveyDTO mapRow(ResultSet rs, int row) throws SQLException {
					return new CustomerSurveyDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21));
				}
			});

			for (CustomerSurveyDTO CustomerSurveyDTO : results) {
				log.info("Discovered <" + CustomerSurveyDTO + "> in the database.");
			}*/

		}
	}
	
}
