package com.stg.cedh.maritz.util;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.stg.cedh.maritz.dto.CustomerSurveyDTO;
import com.stg.cedh.maritz.dto.CustomerSurveyDTO;
import com.stg.cedh.maritz.processor.CustomerSurveyProcessor;
import com.stg.cedh.maritz.processor.EmailCaptureProcessor;

@EnableBatchProcessing
@Configuration
public class CustomerSurveyDBConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	// begin reader, writer, and processor

	@Bean
	public FlatFileItemReader<CustomerSurveyDTO> csvMaritzReader() {
		FlatFileItemReader<CustomerSurveyDTO> reader = new FlatFileItemReader<CustomerSurveyDTO>();
		//reader.setResource(new ClassPathResource("EmailCapture.csv"));
		reader.setResource(new ClassPathResource("Alfa_Email_Capture.txt"));
		reader.setLineMapper(new DefaultLineMapper<CustomerSurveyDTO>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "RecordKey", "EventType", "VIN", "BodyModelCode", "EmailAddress", "CID",
								"DealerCode", "RONumber", "SalesConsultantSID", "ServiceAdvisorSID", "SurveyNumber",
								"SampleReceivedDate", "RecordState", "NotSent", "ReasonNotSent", "ExclusionReason",
								"HardBounce", "SoftBounce", "FingerPrint", "IP", "SurveyId" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<CustomerSurveyDTO>() {
					{
						setTargetType(CustomerSurveyDTO.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	ItemProcessor<CustomerSurveyDTO, CustomerSurveyDTO> csvMaritzProcessor() {
		return new CustomerSurveyProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<CustomerSurveyDTO> csvMaritzWriter() {
		JdbcBatchItemWriter<CustomerSurveyDTO> csvMaritzWriter = new JdbcBatchItemWriter<CustomerSurveyDTO>();
		csvMaritzWriter
				.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<CustomerSurveyDTO>());
		csvMaritzWriter.setSql(
				"INSERT INTO email_Capture (RecordKey,EventType,VIN,BodyModelCode,EmailAddress,CID,DealerCode,RONumber,SalesConsultantSID,ServiceAdvisorSID,SurveyNumber,SampleReceivedDate,RecordState,NotSent,ReasonNotSent,ExclusionReason,HardBounce,SoftBounce,FingerPrint,IP,SurveyId) VALUES (:RecordKey, :EventType, :VIN, :BodyModelCode, :EmailAddress, :CID, :DealerCode, :RONumber, :SalesConsultantSID, :ServiceAdvisorSID, :SurveyNumber, :SampleReceivedDate, :RecordState, :NotSent, :ReasonNotSent, :ExclusionReason, :HardBounce, :SoftBounce, :FingerPrint, :IP, :SurveyId)");
		csvMaritzWriter.setDataSource(dataSource);
		return csvMaritzWriter;
	}

	// end reader, writer, and processor

	// begin job info
	@Bean
	public Step csvFileToDatabaseStep() {
		return stepBuilderFactory.get("csvFileToDatabaseStep").<CustomerSurveyDTO, CustomerSurveyDTO>chunk(1)
				.reader(csvMaritzReader())
				.processor(csvMaritzProcessor())
				.writer(csvMaritzWriter())
				.build();
	}

	@Bean
	Job csvFileToDatabaseJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("csvFileToDatabaseJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(csvFileToDatabaseStep())
				.end()
				.build();
	}
	// end job info
}
