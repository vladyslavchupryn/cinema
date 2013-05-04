package ua.pp.chuprin.web100.cinema.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;

import ua.pp.chuprin.web100.cinema.tools.crud.annotations.CRUD;

@Entity
@Table(name = "\"Places\"")
public class Place {
	@Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Id
	@GeneratedValue(
		generator = "place_sequence_generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
		name = "place_sequence_generator",
		sequenceName = "\"Places_id_seq\"",
		allocationSize = 1
	)
	private Integer id;

	@Column(name = "\"number\"", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
	@Basic
	@NotNull
	@Min(0)
	@CRUD(order = 100)
	private Short number;

	@OneToMany(mappedBy = "place")
	private Collection<Order> orders;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"categoryID\"", referencedColumnName = "id", nullable = false)
	@NotNull
	@CRUD(order = 200)
	private Category category;

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getNumber() {
		return number;
	}

	public void setNumber(Short number) {
		this.number = number;
	}

	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> ordersesById) {
		this.orders = ordersesById;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (number != null ? number.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Place place = (Place) o;

		if (id != null ? !id.equals(place.id) : place.id != null)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return category.getHall() + " : " + number;
	}
}
