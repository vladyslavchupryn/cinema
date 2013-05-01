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
	name = "\"TimeStepType\"",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "name"),
		@UniqueConstraint(columnNames = "value")
	}
)
@org.hibernate.annotations.Entity(mutable = false)
public class TimeStepType {

	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "time_step_type_id_generator")
	@SequenceGenerator(
		name = "time_step_type_id_generator",
		sequenceName = "\"Type_id_seq\""
	)
	@Column(name = "\"id\"")
	@Basic
	private Short id;

	@Column(name = "\"name\"")
	@Basic
	private String name;

	@Column(name = "\"value\"")
	@Basic
	private String value;

	public Short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
