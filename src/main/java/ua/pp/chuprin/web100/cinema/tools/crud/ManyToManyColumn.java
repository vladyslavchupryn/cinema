package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

import org.springframework.util.StringUtils;

public class ManyToManyColumn extends Column {

	private final Collection variants;

	private final String relation;

	public ManyToManyColumn(Class clazz, String name, String cssClass, short order, Collection variants, Class joinType) {
		super(clazz, name, cssClass, order);
		this.variants = variants;
		this.relation = StringUtils.uncapitalize(joinType.getSimpleName());
	}

	public String getRelation() {
		return relation;
	}

	@Override
	public String getType() {
		return "many-to-many";
	}

	public Collection getVariants() {
		return variants;
	}
}
