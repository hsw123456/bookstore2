package com.hsw.bookstore.dao;

import com.hsw.bookstore.domain.Account;

public interface AccountDao {
	

	/**
	 * ���� accountId ��ȡ��Ӧ�� Account ����
	 * @param accountId
	 * @return
	 */
	public abstract Account get(Long accountId);

	/**
	 * ���ݴ���� accountId, amount ����ָ���˻������: �۳� amount ָ����Ǯ��
	 * @param accountId
	 * @param amount
	 */
	public abstract void updateBalance(Long accountId, float amount);

}


