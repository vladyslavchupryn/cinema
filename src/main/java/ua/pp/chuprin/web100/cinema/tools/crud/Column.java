package ua.pp.chuprin.web100.cinema.tools.crud;

public class Column implements Comparable<Column> {

	private final String name;
	private final String cssClass;
	private final int order;

	private String template;

	public Column(String name, String cssClass, int order) {
		this.name = name;
		this.cssClass = cssClass;
		this.order = order;
	}

	@Override
	public int compareTo(Column other) {
		return order - other.order;
	}

	public String getName() {
		return name;
	}

	public String getCssClass() {
		return cssClass;
	}

	public int getOrder() {
		return order;
	}
}
