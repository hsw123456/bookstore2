package com.hsw.bookstore.dao;

import java.util.Set;

import com.hsw.bookstore.domain.Trade;

public interface TradeDao {

	/**
	 * �����ݱ��в��� Trade ����
	 * @param trade
	 */
	public abstract void insert(Trade trade);

	/**
	 * ���� userId ��ȡ��������� Trade �ļ���
	 * @param userId
	 * @return
	 */
	public abstract Set<Trade> getTradesWithUserId(Long userId);

}