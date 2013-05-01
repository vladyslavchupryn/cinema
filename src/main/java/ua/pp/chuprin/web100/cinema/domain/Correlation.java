package ua.pp.chuprin.web100.cinema.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "`Correlations`")
public class Correlation {

	@Column(
		name = "`id`",
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
		sequenceName = "`Correlations_id_seq`",
		allocationSize = 1
	)
	private Integer id;

	@Column(
		name = "`name`",
		nullable = false,
		insertable = true,
		updatable = true,
		length = 2147483647,
		precision = 0
	)
	@Basic
	private String name;

	@Column(
		name = "`percent`",
		nullable = false,
		insertable = true,
		updatable = true,
		length = 8,
		precision = 8
	)
	@Basic
	private Float percent;

	@Column(
		name = "`expiration`",
		nullable = false,
		insertable = true,
		updatable = true,
		length = 29,
		precision = 6
	)
	@Basic
	private Timestamp expiration;

	@OneToMany(mappedBy = "`correlationsByCorrelationId`")
	private Collection<OrderCorrelation> ordersCorrelationsesById;

	public Timestamp getExpiration() {
		return expiration;
	}

	public void setExpiration(Timestamp expiration) {
		this.expiration = expiration;
	}

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

	public Collection<OrderCorrelation> getOrdersCorrelationsesById() {
		return ordersCorrelationsesById;
	}

	public void setOrdersCorrelationsesById(Collection<OrderCorrelation> ordersCorrelationsesById) {
		this.ordersCorrelationsesById = ordersCorrelationsesById;
	}

	public Float getPercent() {
		return percent;
	}

	public void setPercent(Float percent) {
		this.percent = percent;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (percent != null ? percent.hashCode() : 0);
		result = 31 * result + (expiration != null ? expiration.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Correlation that = (Correlation) o;

		if (expiration != null ? !expiration.equals(that.expiration) : that.expiration != null)
			return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (percent != null ? !percent.equals(that.percent) : that.percent != null)
			return false;

		return true;
	}
}
