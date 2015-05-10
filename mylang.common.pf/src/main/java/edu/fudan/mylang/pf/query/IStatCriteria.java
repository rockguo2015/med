package edu.fudan.mylang.pf.query;

import java.util.Collection;

import edu.fudan.mylang.pf.IObjectFactory;

public interface IStatCriteria<T> {

	public void setCriteria(IQueryCriteria<?> queryCriteria);
	public void setObjectFactory(IObjectFactory objectFactory);
	public Collection<T> list();

}
