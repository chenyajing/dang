package com.cyj.core.service;

import java.util.List;

import com.cyj.core.po.ReceiveAddress;

public interface ReceiveAddressService {

	public void save(ReceiveAddress addr);
	public List<ReceiveAddress> findByUserId(int userId);
	public ReceiveAddress findById(int id);
}
