package ua.pp.chuprin.web100.cinema.tools;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SorterBuilder {
	private static final String DEFAULT_SORT = "asc";

	@Autowired
	private SessionFactory factory;

	public static class Sorter {

		public final String column;

		public final String oder;

		public Sorter(String column, String oder) {
			this.column = column;
			this.oder = oder;
		}

		public String hql() {
			return " order by " + column + " " + oder;
		}
	}

	public Sorter build(String sort, Class entity) {
		ClassMetadata meta = factory.getClassMetadata(entity);

		String column = meta.getIdentifierPropertyName();
		String oder = DEFAULT_SORT;

		String[] sortSettings = sort.split("-");
		if (sortSettings.length == 2) {
			for (String property : meta.getPropertyNames()) {
				if (sortSettings[0].equals(property)) {
					column = property;
					break;
				}
			}

			if ("desc".equals(sortSettings[1])) {
				oder = "desc";
			}
		}

		return new Sorter(column, oder);
	}
}
