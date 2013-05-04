package ua.pp.chuprin.web100.cinema.tools;

import java.lang.reflect.Field;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SorterBuilder<T> {
	private static final String DEFAULT_SORT = "asc";

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

	public static Sorter build(String sort, Class entity) {
		String column = "id";
		String oder = DEFAULT_SORT;

		String[] sortSettings = sort.split("-");
		if (sortSettings.length == 2) {
			for (Field field : entity.getFields()) {
				if (sortSettings[0].equals(field.getName())) {
					column = field.getName();
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
