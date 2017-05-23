package com.hsw.bookstore.daoImpl;

import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.hsw.bookstore.dao.TradeItemDao;
import com.hsw.bookstore.domain.TradeItem;

@Repository("tradeItemDao")
public class TradeItemDaoImpl extends BaseDaoImpl<TradeItem> implements TradeItemDao {

	@Override
	public void batchSave(Collection<TradeItem> items) {
		/*String sql = "INSERT INTO tradeitem(bookid, quantity, tradeid) " +
				"VALUES(?,?,?)";
		Object [][] params = new Object[items.size()][3];
		
		//List<TradeItem> tradeItems = new ArrayList<>(items);
		for(int i = 0; i < tradeItems.size(); i++){
			params[i][0] = tradeItems.get(i).getBookId();
			params[i][1] = tradeItems.get(i).getQuantity();
			params[i][2] = tradeItems.get(i).getTradeId(); 
		}*/
		
		for(TradeItem item: items){
			getSession().save(item);
		}
		
	}

	@Override
	public Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId) {
		String hql = "FROM tradeitem WHERE tradeid = ?";
		return (Set<TradeItem>) getSession().createQuery(hql).list();
	}

}
