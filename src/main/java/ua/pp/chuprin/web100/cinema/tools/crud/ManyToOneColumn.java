package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

public class ManyToOneColumn extends Column {

	private final Collection variants;

	public ManyToOneColumn(String name, String cssClass, int order, Collection variants) {
		super(name, cssClass, order);
		this.variants = variants;
	}

	public Collection getVariants() {
		return variants;
	}
}
