package ua.pp.chuprin.web100.cinema.tools;

import java.lang.reflect.Field;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;

@Component
public class SorterBuilder<T> {

	public static Sorter build(String sort, Class entity) {
		String column = "id";
		OrderType oder = OrderType.ASC;

		String[] sortSettings = sort.split("-");
		if (sortSettings.length == 2) {
			for (Field field : entity.getFields()) {
				if (sortSettings[0].equals(field.getName())) {
					column = field.getName();
					break;
				}
			}

			if ("desc".equals(sortSettings[1])) {
				oder = OrderType.DESC;
			}
		}

		return new Sorter(column, oder);
	}

	private static enum OrderType {
		ASC,
		DESC
	}

	public static class Sorter {

		public final String column;

		public final OrderType oder;

		public Sorter(String column, OrderType oder) {
			this.column = column;
			this.oder = oder;
		}

		public Order order() {
			if (oder == OrderType.DESC) {
				return Order.desc(column);
			} else {
				return Order.asc(column);
			}
		}
	}
}
