/**
 * 2018年1月27日
 * Yang.Liu
 */
package com.yang.core.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yang.core.ChannelJpqlQuery;
import com.yang.core.ChannelNamedQuery;
import com.yang.core.ChannelQuery;
import com.yang.core.ChannelSqlQuery;
import com.yang.core.EntityRepository;
import com.yang.core.InstanceFactory;
import com.yang.core.Page;
import com.yang.core.QueryChannelService;

/**
 * Package : com.yang.core.impl
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月27日 下午9:58:27
 *
 */
@Service("queryChannel")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class QueryChannelServiceImpl implements QueryChannelService {

    private static final long serialVersionUID = -1045471527037313221L;
    // @Autowired
    private EntityRepository repository;

    private EntityRepository getEntityRepository() {
        if (null == repository) {
            repository = InstanceFactory.getInstance(EntityRepository.class);
        }
        return repository;
    }

    @Override
    public ChannelJpqlQuery createJpqlQuery(String jpql) {
        return new ChannelJpqlQuery(getEntityRepository(), jpql);
    }

    @Override
    public ChannelNamedQuery createNamedQuery(String queryName) {
        return new ChannelNamedQuery(getEntityRepository(), queryName);
    }

    @Override
    public ChannelSqlQuery createSqlQuery(String sql) {
        return new ChannelSqlQuery(getEntityRepository(), sql);
    }

    @Override
    public <T> List<T> list(ChannelQuery query) {
        return query.list();
    }

    @Override
    public <T> Page<T> pagedList(ChannelQuery query) {
        return query.pagedList();
    }

    @Override
    public <T> T getSingleResult(ChannelQuery query) {
        return (T) query.singleResult();
    }

    @Override
    public long getResultCount(ChannelQuery query) {
        return query.queryResultCount();
    }
}
