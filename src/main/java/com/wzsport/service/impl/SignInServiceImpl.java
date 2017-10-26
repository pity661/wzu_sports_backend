package com.wzsport.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wzsport.mapper.SignInMapper;
import com.wzsport.model.SignIn;
import com.wzsport.service.SignInService;

@Service
public class SignInServiceImpl implements SignInService {
	@Autowired
	SignInMapper signInMapper;

	private static final Logger logger = LogManager.getLogger(SignInServiceImpl.class);

	@Override
	@Transactional
	public boolean create() {
		Calendar c = Calendar.getInstance();
		Calendar calFirst = Calendar.getInstance();
		Calendar calLast = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		int today = 	c.get(Calendar.DAY_OF_MONTH);
		// 如果是本月第一天，取上个月第一天和最后一天,否则，取本月
		if (today == 1) {
			calFirst.add(Calendar.MONTH, -1); // 上一个月
			calFirst.set(Calendar.DAY_OF_MONTH, 1);

			calLast.set(Calendar.DAY_OF_MONTH,0);
			System.out.println("-----1------firstDay:"+format.format(calFirst.getTime()));
			System.out.println("-----2------lastDay:"+format.format(calLast.getTime()));
		} else {
			calFirst.add(Calendar.MONTH, 0);
			calFirst.set(Calendar.DAY_OF_MONTH,1);

			calLast.set(Calendar.DAY_OF_MONTH, calLast.getActualMaximum(Calendar.DAY_OF_MONTH));
			System.out.println("-----3------firstDay:"+format.format(calFirst.getTime()));
			System.out.println("-----4------lastDay:"+format.format(calLast.getTime()));
		}

		List<SignIn> list = signInMapper.getSignInDataList(calFirst.getTime(), calLast.getTime());

		for (SignIn signIn : list) {
			try {
				signInMapper.insert(signIn);
			} catch (Exception e) {
				logger.error(e);
			}

		}

		return true;
	}
}
