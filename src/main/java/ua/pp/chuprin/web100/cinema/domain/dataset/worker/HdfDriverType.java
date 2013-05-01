package ua.pp.chuprin.web100.cinema.domain.dataset.worker;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
	name = "`HDFDriverType`",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "name"),
		@UniqueConstraint(columnNames = "value")
	}
)
public class HdfDriverType extends Type {
}
