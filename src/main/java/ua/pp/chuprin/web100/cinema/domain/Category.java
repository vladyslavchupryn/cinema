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
		name = "\"price\"",
		nullable = false,
		insertable = true,
		updatable = true,
		length = 2147483647,
		precision = 0
	)
	@Basic
	private Double price;

	@ManyToOne (
		fetch = FetchType.LAZY
	)
	@JoinColumn(
		name = "\"hallID\"",
		referencedColumnName = "id",
		nullable = false,
		updatable = true,
		insertable = true
	)
	private Hall hall;

	@ManyToOne (
		fetch = FetchType.LAZY
	)
	@JoinColumn(
		name = "\"typeID\"",
		referencedColumnName = "id",
		nullable = false,
		updatable = true,
		insertable = true
	)
	private PlaceType placeType;

	@OneToMany(mappedBy = "category")
	private Collection<Place> places;

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hallByHallId) {
		this.hall = hallByHallId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PlaceType getPlaceType() {
		return placeType;
	}

	public void setPlaceType(PlaceType placeTypeByTypeId) {
		this.placeType = placeTypeByTypeId;
	}

	public Collection<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Collection<Place> placesesById) {
		this.places = placesesById;
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

	@Override
	public String toString() {
		return hall + " - " + placeType;
	}
}
