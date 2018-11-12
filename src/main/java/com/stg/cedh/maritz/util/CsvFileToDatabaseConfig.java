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

import com.stg.cedh.maritz.dto.EmailCaptureDTO;
import com.stg.cedh.maritz.processor.EmailCaptureProcessor;

@EnableBatchProcessing
@Configuration
public class CsvFileToDatabaseConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	// begin reader, writer, and processor

	@Bean
	public FlatFileItemReader<EmailCaptureDTO> csvMaritzReader() {
		FlatFileItemReader<EmailCaptureDTO> reader = new FlatFileItemReader<EmailCaptureDTO>();
		//reader.setResource(new ClassPathResource("EmailCapture.csv"));
		reader.setResource(new ClassPathResource("Alfa_Email_Capture.txt"));
		reader.setLineMapper(new DefaultLineMapper<EmailCaptureDTO>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "RecordKey", "EventType", "VIN", "BodyModelCode", "EmailAddress", "CID",
								"DealerCode", "RONumber", "SalesConsultantSID", "ServiceAdvisorSID", "SurveyNumber",
								"SampleReceivedDate", "RecordState", "NotSent", "ReasonNotSent", "ExclusionReason",
								"HardBounce", "SoftBounce", "FingerPrint", "IP", "SurveyId" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<EmailCaptureDTO>() {
					{
						setTargetType(EmailCaptureDTO.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	ItemProcessor<EmailCaptureDTO, EmailCaptureDTO> csvMaritzProcessor() {
		return new EmailCaptureProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<EmailCaptureDTO> csvMaritzWriter() {
		JdbcBatchItemWriter<EmailCaptureDTO> csvMaritzWriter = new JdbcBatchItemWriter<EmailCaptureDTO>();
		csvMaritzWriter
				.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<EmailCaptureDTO>());
		csvMaritzWriter.setSql(
				"INSERT INTO email_Capture (RecordKey,EventType,VIN,BodyModelCode,EmailAddress,CID,DealerCode,RONumber,SalesConsultantSID,ServiceAdvisorSID,SurveyNumber,SampleReceivedDate,RecordState,NotSent,ReasonNotSent,ExclusionReason,HardBounce,SoftBounce,FingerPrint,IP,SurveyId) VALUES (:RecordKey, :EventType, :VIN, :BodyModelCode, :EmailAddress, :CID, :DealerCode, :RONumber, :SalesConsultantSID, :ServiceAdvisorSID, :SurveyNumber, :SampleReceivedDate, :RecordState, :NotSent, :ReasonNotSent, :ExclusionReason, :HardBounce, :SoftBounce, :FingerPrint, :IP, :SurveyId)");
		csvMaritzWriter.setDataSource(dataSource);
		return csvMaritzWriter;
	}

	// end reader, writer, and processor

	// begin job info
	@Bean
	public Step csvFileToDatabaseStep() {
		return stepBuilderFactory.get("csvFileToDatabaseStep").<EmailCaptureDTO, EmailCaptureDTO>chunk(1)
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
