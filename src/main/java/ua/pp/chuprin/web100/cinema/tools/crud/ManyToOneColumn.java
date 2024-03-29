package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

public class ManyToOneColumn extends Column {

	private final Collection variants;

	public ManyToOneColumn(Class clazz, String name, String cssClass, short order, Collection variants) {
		super(clazz, name, cssClass, order);
		this.variants = variants;
	}

	@Override
	public String getType() {
		return "many-to-one";
	}

	public Collection getVariants() {
		return variants;
	}
}
