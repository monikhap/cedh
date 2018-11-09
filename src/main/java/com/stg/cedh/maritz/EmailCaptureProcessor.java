package com.stg.cedh.maritz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class EmailCaptureProcessor implements ItemProcessor<EmailCaptureDTO, EmailCaptureDTO>{
	
private static final Logger log = LoggerFactory.getLogger(EmailCaptureProcessor.class);
    
    public EmailCaptureDTO process(final EmailCaptureDTO emailCaptureDTO) throws Exception {
    	
    	final String recordKey=emailCaptureDTO.getRecordKey();
    	final String eventType=emailCaptureDTO.getEventType();
    	final String VIN=emailCaptureDTO.getVIN();
    	final String bodyModelCode=emailCaptureDTO.getBodyModelCode();
    	final String emailAddress=emailCaptureDTO.getEmailAddress();
    	final String CID=emailCaptureDTO.getCID();
    	final String dealerCode=emailCaptureDTO.getDealerCode();
    	final String RONumber=emailCaptureDTO.getRONumber();
    	final String salesConsultantSID=emailCaptureDTO.getSalesConsultantSID();
    	final String serviceAdvisorSID=emailCaptureDTO.getServiceAdvisorSID();
    	final String surveyNumber=emailCaptureDTO.getSurveyNumber();
    	final String sampleReceivedDate=emailCaptureDTO.getSampleReceivedDate();
    	final String recordState=emailCaptureDTO.getRecordState();
    	final String notSent=emailCaptureDTO.getNotSent();
    	final String reasonNotSent=emailCaptureDTO.getReasonNotSent();
    	final String exclusionReason=emailCaptureDTO.getExclusionReason();
    	final String hardBounce=emailCaptureDTO.getHardBounce();
    	final String softBounce=emailCaptureDTO.getSoftBounce();
    	final String fingerPrint=emailCaptureDTO.getFingerPrint();
    	final String IP=emailCaptureDTO.getIP();
    	final String surveyId=emailCaptureDTO.getSurveyId();
    	
        final EmailCaptureDTO transformedEmailCaptureDTO = new EmailCaptureDTO(recordKey, eventType, VIN, bodyModelCode, emailAddress, CID, dealerCode, RONumber, salesConsultantSID, serviceAdvisorSID, surveyNumber, sampleReceivedDate, recordState, notSent, reasonNotSent, exclusionReason, hardBounce, softBounce, fingerPrint, IP, surveyId);

        log.info("Converting (" + emailCaptureDTO + ") into (" + transformedEmailCaptureDTO + ")");

        return transformedEmailCaptureDTO;
    }

}
