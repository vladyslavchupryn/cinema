package ua.pp.chuprin.web100.cinema.tools.crud;

public class Column implements Comparable<Column> {

	private final String name;
	private final String cssClass;
	private final short order;

	private final Class clazz;

	public Column(Class clazz, String name, String cssClass, short order) {
		this.name = name;
		this.cssClass = cssClass;
		this.order = order;

		this.clazz = clazz;
	}

	public Class getClazz() {
		return clazz;
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

	public String getType() {
		return "simple";
	}
}
