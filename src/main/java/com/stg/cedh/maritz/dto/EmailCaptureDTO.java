package com.stg.cedh.maritz.dto;

public class EmailCaptureDTO {

	public String RecordKey;
	public String EventType;
	public String VIN;
	public String BodyModelCode;
	public String EmailAddress;
	public String CID;
	public String DealerCode;
	public String RONumber;
	public String SalesConsultantSID;
	public String ServiceAdvisorSID;
	public String SurveyNumber;
	public String SampleReceivedDate;
	public String RecordState;
	public String NotSent;
	public String ReasonNotSent;
	public String ExclusionReason;
	public String HardBounce;
	public String SoftBounce;
	public String FingerPrint;
	public String IP;
	public String SurveyId;

	public EmailCaptureDTO() {
	}

	public EmailCaptureDTO(String recordKey, String eventType, String VIN, String bodyModelCode, String emailAddress,
			String CID, String dealerCode, String RONumber, String salesConsultantSID, String serviceAdvisorSID,
			String surveyNumber, String sampleReceivedDate, String recordState, String notSent, String reasonNotSent,
			String exclusionReason, String hardBounce, String softBounce, String fingerPrint, String IP,
			String surveyId) {
		super();
		RecordKey = recordKey;
		EventType = eventType;
		this.VIN = VIN;
		BodyModelCode = bodyModelCode;
		EmailAddress = emailAddress;
		this.CID = CID;
		DealerCode = dealerCode;
		this.RONumber = RONumber;
		SalesConsultantSID = salesConsultantSID;
		ServiceAdvisorSID = serviceAdvisorSID;
		SurveyNumber = surveyNumber;
		SampleReceivedDate = sampleReceivedDate;
		RecordState = recordState;
		NotSent = notSent;
		ReasonNotSent = reasonNotSent;
		ExclusionReason = exclusionReason;
		HardBounce = hardBounce;
		SoftBounce = softBounce;
		FingerPrint = fingerPrint;
		this.IP = IP;
		SurveyId = surveyId;
	}

	public String getRecordKey() {
		return RecordKey;
	}

	public void setRecordKey(String recordKey) {
		RecordKey = recordKey;
	}

	public String getEventType() {
		return EventType;
	}

	public void setEventType(String eventType) {
		EventType = eventType;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String VIN) {
		VIN = VIN;
	}

	public String getBodyModelCode() {
		return BodyModelCode;
	}

	public void setBodyModelCode(String bodyModelCode) {
		BodyModelCode = bodyModelCode;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getCID() {
		return CID;
	}

	public void setCID(String CID) {
		CID = CID;
	}

	public String getDealerCode() {
		return DealerCode;
	}

	public void setDealerCode(String dealerCode) {
		DealerCode = dealerCode;
	}

	public String getRONumber() {
		return RONumber;
	}

	public void setRONumber(String RONumber) {
		RONumber = RONumber;
	}

	public String getSalesConsultantSID() {
		return SalesConsultantSID;
	}

	public void setSalesConsultantSID(String salesConsultantSID) {
		SalesConsultantSID = salesConsultantSID;
	}

	public String getServiceAdvisorSID() {
		return ServiceAdvisorSID;
	}

	public void setServiceAdvisorSID(String serviceAdvisorSID) {
		ServiceAdvisorSID = serviceAdvisorSID;
	}

	public String getSurveyNumber() {
		return SurveyNumber;
	}

	public void setSurveyNumber(String surveyNumber) {
		SurveyNumber = surveyNumber;
	}

	public String getSampleReceivedDate() {
		return SampleReceivedDate;
	}

	public void setSampleReceivedDate(String sampleReceivedDate) {
		SampleReceivedDate = sampleReceivedDate;
	}

	public String getRecordState() {
		return RecordState;
	}

	public void setRecordState(String recordState) {
		RecordState = recordState;
	}

	public String getNotSent() {
		return NotSent;
	}

	public void setNotSent(String notSent) {
		NotSent = notSent;
	}

	public String getReasonNotSent() {
		return ReasonNotSent;
	}

	public void setReasonNotSent(String reasonNotSent) {
		ReasonNotSent = reasonNotSent;
	}

	public String getExclusionReason() {
		return ExclusionReason;
	}

	public void setExclusionReason(String exclusionReason) {
		ExclusionReason = exclusionReason;
	}

	public String getHardBounce() {
		return HardBounce;
	}

	public void setHardBounce(String hardBounce) {
		HardBounce = hardBounce;
	}

	public String getSoftBounce() {
		return SoftBounce;
	}

	public void setSoftBounce(String softBounce) {
		SoftBounce = softBounce;
	}

	public String getFingerPrint() {
		return FingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		FingerPrint = fingerPrint;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String IP) {
		IP = IP;
	}

	public String getSurveyId() {
		return SurveyId;
	}

	public void setSurveyId(String surveyId) {
		SurveyId = surveyId;
	}

	@Override
	public String toString() {
		return "EmailCaptureDTO [RecordKey=" + RecordKey + ", EventType=" + EventType + ", VIN=" + VIN
				+ ", BodyModelCode=" + BodyModelCode + ", EmailAddress=" + EmailAddress + ", CID=" + CID
				+ ", DealerCode=" + DealerCode + ", RONumber=" + RONumber + ", SalesConsultantSID=" + SalesConsultantSID
				+ ", ServiceAdvisorSID=" + ServiceAdvisorSID + ", SurveyNumber=" + SurveyNumber
				+ ", SampleReceivedDate=" + SampleReceivedDate + ", RecordState=" + RecordState + ", NotSent=" + NotSent
				+ ", ReasonNotSent=" + ReasonNotSent + ", ExclusionReason=" + ExclusionReason + ", HardBounce="
				+ HardBounce + ", SoftBounce=" + SoftBounce + ", FingerPrint=" + FingerPrint + ", IP=" + IP
				+ ", SurveyId=" + SurveyId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailCaptureDTO other = (EmailCaptureDTO) obj;
		if (BodyModelCode == null) {
			if (other.BodyModelCode != null)
				return false;
		} else if (!BodyModelCode.equals(other.BodyModelCode))
			return false;
		if (CID == null) {
			if (other.CID != null)
				return false;
		} else if (!CID.equals(other.CID))
			return false;
		if (DealerCode == null) {
			if (other.DealerCode != null)
				return false;
		} else if (!DealerCode.equals(other.DealerCode))
			return false;
		if (EmailAddress == null) {
			if (other.EmailAddress != null)
				return false;
		} else if (!EmailAddress.equals(other.EmailAddress))
			return false;
		if (EventType == null) {
			if (other.EventType != null)
				return false;
		} else if (!EventType.equals(other.EventType))
			return false;
		if (ExclusionReason == null) {
			if (other.ExclusionReason != null)
				return false;
		} else if (!ExclusionReason.equals(other.ExclusionReason))
			return false;
		if (FingerPrint == null) {
			if (other.FingerPrint != null)
				return false;
		} else if (!FingerPrint.equals(other.FingerPrint))
			return false;
		if (HardBounce == null) {
			if (other.HardBounce != null)
				return false;
		} else if (!HardBounce.equals(other.HardBounce))
			return false;
		if (IP == null) {
			if (other.IP != null)
				return false;
		} else if (!IP.equals(other.IP))
			return false;
		if (NotSent == null) {
			if (other.NotSent != null)
				return false;
		} else if (!NotSent.equals(other.NotSent))
			return false;
		if (RONumber == null) {
			if (other.RONumber != null)
				return false;
		} else if (!RONumber.equals(other.RONumber))
			return false;
		if (ReasonNotSent == null) {
			if (other.ReasonNotSent != null)
				return false;
		} else if (!ReasonNotSent.equals(other.ReasonNotSent))
			return false;
		if (RecordKey == null) {
			if (other.RecordKey != null)
				return false;
		} else if (!RecordKey.equals(other.RecordKey))
			return false;
		if (RecordState == null) {
			if (other.RecordState != null)
				return false;
		} else if (!RecordState.equals(other.RecordState))
			return false;
		if (SalesConsultantSID == null) {
			if (other.SalesConsultantSID != null)
				return false;
		} else if (!SalesConsultantSID.equals(other.SalesConsultantSID))
			return false;
		if (SampleReceivedDate == null) {
			if (other.SampleReceivedDate != null)
				return false;
		} else if (!SampleReceivedDate.equals(other.SampleReceivedDate))
			return false;
		if (ServiceAdvisorSID == null) {
			if (other.ServiceAdvisorSID != null)
				return false;
		} else if (!ServiceAdvisorSID.equals(other.ServiceAdvisorSID))
			return false;
		if (SoftBounce == null) {
			if (other.SoftBounce != null)
				return false;
		} else if (!SoftBounce.equals(other.SoftBounce))
			return false;
		if (SurveyId == null) {
			if (other.SurveyId != null)
				return false;
		} else if (!SurveyId.equals(other.SurveyId))
			return false;
		if (SurveyNumber == null) {
			if (other.SurveyNumber != null)
				return false;
		} else if (!SurveyNumber.equals(other.SurveyNumber))
			return false;
		if (VIN == null) {
			if (other.VIN != null)
				return false;
		} else if (!VIN.equals(other.VIN))
			return false;
		return true;
	}

}
