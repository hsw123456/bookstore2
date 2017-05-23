package com.hsw.bookstore.daoImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.hsw.bookstore.dao.TradeDao;
import com.hsw.bookstore.domain.Trade;

@Repository("tradeDao")
public class TradeDaoImpl extends BaseDaoImpl<Trade> implements TradeDao{

	@Override
	public void insert(Trade trade) {
		save(trade);
	}

	@Override
	public Set<Trade> getTradesWithUserId(Long userId) {
		String sql = "SELECT tradeId, userId, tradeTime FROM trade " +
				"WHERE userId = ? ORDER BY tradeTime DESC";
		return (Set<Trade>) getSession().createQuery(sql).setParameter(0, userId).list();
	}

}
