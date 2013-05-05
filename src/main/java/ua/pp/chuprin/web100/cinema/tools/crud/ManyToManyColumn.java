package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

public class ManyToManyColumn extends Column {

	private final Collection variants;

	public ManyToManyColumn(String name, String cssClass, short order, Collection variants) {
		super(name, cssClass, order);
		this.variants = variants;
	}

	@Override
	public String getType() {
		return "many-to-many";
	}

	public Collection getVariants() {
		return variants;
	}
}
