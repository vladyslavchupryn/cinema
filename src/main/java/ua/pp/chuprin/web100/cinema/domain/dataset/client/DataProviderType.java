package ua.pp.chuprin.web100.cinema.domain.dataset.client;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
	name = "`DataProviderType`",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "`name`"),
		@UniqueConstraint(columnNames = "`value`")
	}
)

/**
 генератор на основе SequenceGenerator по JPA

 есть вариант GenericGenerator от hibernate see {@link LayerType}
 */
@SequenceGenerator(
	name = "data_provider_type_generator",
	sequenceName = "\"Type_id_seq\""
)
@org.hibernate.annotations.Entity(
	mutable = false // сейчас типы неизменны и добавляются через pgAdmin
)
public class DataProviderType {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_provider_type_generator")
	private Short id;

	@Column(name = "`name`")
	@Basic
	private String name;

	@Column(name = "`value`")
	@Basic
	private String value;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
