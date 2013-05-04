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

	@Column(name = "\"name\"", nullable = false, insertable = true, updatable = true, length = 126, precision = 0)
	@Basic
	@NotNull
	@Length(min = 3, max = 126)
	private String name;

	@Override
	public String toString() {
		return name;
	}

	@OneToMany(mappedBy = "hall")
	private Collection<Category> categories;

	@OneToMany(mappedBy = "hall")
	private Collection<Session> sessions;

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

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Collection<Session> sessionsesById) {
		this.sessions = sessionsesById;
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
