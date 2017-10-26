package com.wzsport.service;

import java.util.List;

import com.wzsport.model.ClientVersion;
import com.wzsport.util.ResponseBody;

public interface ClientVersionService {

	ClientVersion getLatestVersionInfo(byte platformId);

	@SuppressWarnings("rawtypes")
	int create(ClientVersion info, ResponseBody resBody);

	@SuppressWarnings("rawtypes")
	int update(ClientVersion info, ResponseBody resBody);

	@SuppressWarnings("rawtypes")
	int index(List<ClientVersion> list, ResponseBody resBody);

	@SuppressWarnings("rawtypes")
	int read(ClientVersion info, ResponseBody resBody);

}
