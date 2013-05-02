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
import java.util.Collection;

@Entity
@Table(name = "\"Halls\"")
public class Hall {
	@Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Id
	@GeneratedValue(
		generator = "hall_sequence_generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
		name = "hall_sequence_generator",
		sequenceName = "\"Halls_id_seq\"",
		allocationSize = 1
	)
	private Integer id;

	@Column(name = "name", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
	@Basic
	private String name;

	@OneToMany(mappedBy = "hallByHallId")
	private Collection<Category> categoriesesById;

	@OneToMany(mappedBy = "hallByHallId")
	private Collection<Session> sessionsesById;

	public Collection<Category> getCategoriesesById() {
		return categoriesesById;
	}

	public void setCategoriesesById(Collection<Category> categoriesesById) {
		this.categoriesesById = categoriesesById;
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

	public Collection<Session> getSessionsesById() {
		return sessionsesById;
	}

	public void setSessionsesById(Collection<Session> sessionsesById) {
		this.sessionsesById = sessionsesById;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Hall hall = (Hall) o;

		if (id != null ? !id.equals(hall.id) : hall.id != null) return false;
		if (name != null ? !name.equals(hall.name) : hall.name != null)
			return false;

		return true;
	}
}
