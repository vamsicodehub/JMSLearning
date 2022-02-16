package com.springsms.demo.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springsms.demo.model.SMSModel;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.Message.Status;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class SMSService {

	private static final Logger logger = LoggerFactory.getLogger(SMSService.class);

	@Value("${accountSID}")
	private String accountSID;

	@Value("${accountAuthToken}")
	private String accountAuthToken;

	@Value("${sender}")
	private String sender;

	public String sendSMS(SMSModel model) {
		try {
			Twilio.init(accountSID, accountAuthToken);

			String smsText = model.getMessage();
			String mobileNumber = model.getReceiver();

			PhoneNumber recieverPhoneNumber = new PhoneNumber(mobileNumber);
			PhoneNumber senderTwilloPhoneNumber = new PhoneNumber(sender);

			MessageCreator creator = com.twilio.rest.api.v2010.account.Message.creator(recieverPhoneNumber,
					senderTwilloPhoneNumber, smsText);
			Message create = creator.create();

			BigDecimal billingAmount = create.getPrice();
			Status status = create.getStatus();

			logger.info("BillingAmount {}  Status {} ", billingAmount, status.name());

			logger.info("Message Send Succesfully to the number " + mobileNumber);
			return "Message Sent Succesfully";
		} catch (Exception e) {
			logger.error("Exception in sendMessage Method " + e);
			return "Message Send Fail";
		}
	}

}
