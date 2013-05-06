package ua.pp.chuprin.web100.cinema.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Collection;

import org.hibernate.validator.constraints.Length;
import ua.pp.chuprin.web100.cinema.tools.crud.annotations.CRUD;

@Entity
@Table(name = "\"Correlations\"")
public class Correlation {

	@Column(
		name = "id",
		nullable = false,
		insertable = true,
		updatable = true,
		length = 10,
		precision = 0
	)
	@Id
	@GeneratedValue(
		generator = "correlation_sequence_generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
		name = "correlation_sequence_generator",
		sequenceName = "\"Correlations_id_seq\"",
		allocationSize = 1
	)
	private Integer id;

	@Column(
		name = "\"name\"",
		nullable = false,
		insertable = true,
		updatable = true,
		length = 126,
		precision = 0
	)
	@Basic
	@NotNull
	@Length(min = 3, max = 126)
	@CRUD(order = 100)
	private String name;

	@Column(
		name = "\"percent\"",
		nullable = false,
		insertable = true,
		updatable = true,
		length = 8,
		precision = 8
	)
	@Basic
	@NotNull
	@CRUD(order = 200)
	private Float percent;

	@ManyToMany(mappedBy = "correlations")
	private Collection<Order> orders;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> ordersCorrelationsesById) {
		this.orders = ordersCorrelationsesById;
	}

	public Float getPercent() {
		return percent;
	}

	public void setPercent(Float percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		return name + ": "
			+ (percent > 0.0 ? "+" : "")
			+ percent + "%";
	}
}
