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
import javax.validation.constraints.NotNull;
import java.util.Collection;

import org.hibernate.validator.constraints.Length;
import ua.pp.chuprin.web100.cinema.tools.crud.annotations.CRUD;

@Entity
@Table(name = "\"PlaceTypes\"")
public class PlaceType {

	@Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Id
	@GeneratedValue(
		generator = "placeType_sequence_generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
		name = "placeType_sequence_generator",
		sequenceName = "\"PlaceTypes_id_seq\"",
		allocationSize = 1
	)
	private Integer id;

	@Column(name = "\"name\"", nullable = false, insertable = true, updatable = true, length = 126, precision = 0)
	@Basic
	@NotNull
	@Length(min = 3, max = 126)
	@CRUD(order = 100)
	private String name;

	@OneToMany(mappedBy = "placeType")
	private Collection<Category> categories;

	public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categoriesesById) {
		this.categories = categoriesesById;
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

	@Override
	public String toString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
