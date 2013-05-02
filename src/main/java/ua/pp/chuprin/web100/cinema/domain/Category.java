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
@Table(name = "\"Categories\"")
public class Category {

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
		generator = "category_sequence_generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
		name = "category_sequence_generator",
		sequenceName = "\"Categories_id_seq\"",
		allocationSize = 1
	)
	private Integer id;

	@Column(
		name = "price",
		nullable = false,
		insertable = true,
		updatable = true,
		length = 2147483647,
		precision = 0
	)
	@Basic
	private Double price;

	@ManyToOne
	@JoinColumn(
		name = "hallID",
		referencedColumnName = "id",
		nullable = false
	)
	private Hall hallByHallId;

	@ManyToOne
	@JoinColumn(
		name = "typeID",
		referencedColumnName = "id",
		nullable = false
	)
	private PlaceType placeTypeByTypeId;

	@OneToMany(mappedBy = "categoryByCategoryId")
	private Collection<Place> placesesById;

	public Hall getHallByHallId() {
		return hallByHallId;
	}

	public void setHallByHallId(Hall hallByHallId) {
		this.hallByHallId = hallByHallId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PlaceType getPlaceTypeByTypeId() {
		return placeTypeByTypeId;
	}

	public void setPlaceTypeByTypeId(PlaceType placeTypeByTypeId) {
		this.placeTypeByTypeId = placeTypeByTypeId;
	}

	public Collection<Place> getPlacesesById() {
		return placesesById;
	}

	public void setPlacesesById(Collection<Place> placesesById) {
		this.placesesById = placesesById;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (price != null ? price.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Category that = (Category) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (price != null ? !price.equals(that.price) : that.price != null)
			return false;

		return true;
	}
}
