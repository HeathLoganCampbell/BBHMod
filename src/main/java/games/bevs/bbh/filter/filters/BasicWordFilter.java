package games.bevs.bbh.filter.filters;

import games.bevs.bbh.filter.WordFilter;

public class BasicWordFilter extends WordFilter
{
	@Override
	public String onFilter(String statement)
	{
		return statement;
	}
}
