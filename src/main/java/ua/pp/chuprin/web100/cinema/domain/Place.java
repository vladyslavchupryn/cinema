package ua.pp.chuprin.web100.cinema.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "Places")
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

	@Column(name = "categoryID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Basic
	private Integer categoryId;

	@Column(name = "number", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
	@Basic
	private Short number;

	@OneToMany(mappedBy = "placeByPlaceId")
	private Collection<Order> ordersesById;

	@ManyToOne
	@JoinColumn(name = "categoryID", referencedColumnName = "id", nullable = false)
	private Category categoryByCategoryId;

	public Category getCategoryByCategoryId() {
		return categoryByCategoryId;
	}

	public void setCategoryByCategoryId(Category categoriesByCategoryId) {
		this.categoryByCategoryId = categoriesByCategoryId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	public Collection<Order> getOrdersesById() {
		return ordersesById;
	}

	public void setOrdersesById(Collection<Order> ordersesById) {
		this.ordersesById = ordersesById;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
		result = 31 * result + (number != null ? number.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Place place = (Place) o;

		if (categoryId != null ? !categoryId.equals(place.categoryId) : place.categoryId != null)
			return false;
		if (id != null ? !id.equals(place.id) : place.id != null)
			return false;
		if (number != null ? !number.equals(place.number) : place.number != null)
			return false;

		return true;
	}
}
