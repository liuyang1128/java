/**
 * 2018年1月27日
 * Yang.Liu
 */
package com.yang.core;

import java.util.List;

/**
 * Package : com.yang.core
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月27日 下午10:09:02
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ChannelSqlQuery extends ChannelQuery<ChannelSqlQuery> {

	private final SqlQuery query;

	public ChannelSqlQuery(EntityRepository repository, String sql) {
		super(repository);
		query = new SqlQuery(repository, sql);
		setQuery(query);
	}

	/**
	 * 设置查询的结果实体类型。注意setResultEntityClass()和addScalar()是互斥的， 分别适用于查询结果是实体和标量两种情形
	 *
	 * @param resultEntityClass
	 *            要设置的查询结果类型
	 * @return 该对象本身
	 */
	public ChannelSqlQuery setResultEntityClass(Class<? extends Entity> resultEntityClass) {
		query.setResultEntityClass(resultEntityClass);
		return this;
	}

	@Override
	public <T> List<T> list() {
		return query.list();
	}

	@Override
	public <T> Page<T> pagedList() {
		return new Page<T>(query.getFirstResult(), queryResultCount(), query.getMaxResults(),
				(List<T>) query.list());
	}

	@Override
	public <T> T singleResult() {
		return (T) query.singleResult();
	}

	@Override
	protected String getQueryString() {
		return query.getSql();
	}

	@Override
	protected BaseQuery createBaseQuery(String queryString) {
		return repository.createSqlQuery(queryString);
	}
}
