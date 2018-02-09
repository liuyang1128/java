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
 *		   2018年1月27日 下午10:00:36
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ChannelNamedQuery extends ChannelQuery<ChannelNamedQuery> {

	private NamedQuery query;

	public ChannelNamedQuery(EntityRepository repository, String queryName) {
		super(repository);
		query = new NamedQuery(repository, queryName);
		setQuery(query);
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
		return repository.getQueryStringOfNamedQuery(query.getQueryName());
	}

	@Override
	protected BaseQuery createBaseQuery(String queryString) {
		return repository.createJpqlQuery(queryString);
	}

}