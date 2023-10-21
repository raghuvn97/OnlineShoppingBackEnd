package com.lti.repository;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.lti.entity.OTPTable;

@Repository
public class OTPRepositoryImpl implements OTPRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public int addOtp()
	{
		OTPTable otpTable = new OTPTable();
		Random rand = new Random();
		int otp = rand.nextInt(99999);
		otpTable.setOtpValue(otp);
		this.entityManager.persist(otpTable);
		return otp;
	}
	
	@Override
	public int getLastOTP()
	{
		//first get last otp_id
		String q1 = "select max(otp_id) from otp_table";
		Query query1 = (Query) this.entityManager.createNativeQuery(q1);
		Number otp = (Number) query1.getSingleResult();
		String q2 = "from OTPTable where otpId=:x";
		Query query2 = (Query) this.entityManager.createQuery(q2);
		query2.setParameter("x", otp.intValue());
		OTPTable otpTable = (OTPTable)query2.getSingleResult();
		//then fetch its value
		System.out.println("Fetched value :"+otpTable.getOtpValue());
		return otpTable.getOtpValue();
	}
}
