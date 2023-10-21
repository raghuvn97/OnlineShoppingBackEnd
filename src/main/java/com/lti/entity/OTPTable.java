package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the OTP_TABLE database table.
 * 
 */
@Entity
@Table(name="OTP_TABLE")
public class OTPTable implements Serializable {
	@Id
	@SequenceGenerator(name = "seq_otp", initialValue = 301, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_otp")
	@Column(name="OTP_ID")
	private int otpId;

	@Column(name="OTP_VALUE")
	private int otpValue;

	public OTPTable() {
	}

	public int getOtpId() {
		return this.otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public int getOtpValue() {
		return this.otpValue;
	}

	public void setOtpValue(int otpValue) {
		this.otpValue = otpValue;
	}

}