package com.hsw.bookstore.dao;

import java.util.Collection;
import java.util.Set;

import com.hsw.bookstore.domain.TradeItem;

public interface TradeItemDao {

	/**
	 * �������� TradeItem ����
	 * @param items
	 */
	public abstract void batchSave(Collection<TradeItem> items);

	/**
	 * ���� tradeId ��ȡ��������� TradeItem �ļ���
	 * @param tradeId
	 * @return
	 */
	public abstract Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId);

}

