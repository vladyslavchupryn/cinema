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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Length;
import ua.pp.chuprin.web100.cinema.tools.Interval;
import ua.pp.chuprin.web100.cinema.tools.crud.annotations.CRUD;

@Entity
@Table(name = "`Films`")
@TypeDef(name = "interval", typeClass = Interval.class)
public class Film {
	@Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Id
	@GeneratedValue(
		generator = "film_sequence_generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
		name = "film_sequence_generator",
		sequenceName = "\"Films_id_seq\"",
		allocationSize = 1
	)
	private Integer id;

	@Column(name = "\"name\"", nullable = false, insertable = true, updatable = true, length = 126, precision = 0)
	@Basic
	@NotNull
	@Length(min = 3, max = 126)
	@CRUD(order = 0)
	private String name;

	@Column(name = "\"author\"", nullable = false, insertable = true, updatable = true, length = 126, precision = 0)
	@Basic
	@NotNull
	@Length(min = 3, max = 126)
	@CRUD(order = 1)
	private String author;

	@Column(name = "\"genre\"", nullable = false, insertable = true, updatable = true, length = 126, precision = 0)
	@Basic
	@NotNull
	@Length(min = 3, max = 126)
	@CRUD(order = 2)
	private String genre;

	@Column(name = "\"country\"", nullable = false, insertable = true, updatable = true, length = 126, precision = 0)
	@Basic
	@NotNull
	@Length(min = 3, max = 126)
	@CRUD(order = 3)
	private String country;

	@Column(name = "\"year\"", nullable = false, insertable = true, updatable = true, length = 4, precision = 0)
	@NotNull
	@Basic
	@Min(1800) @Max(2200)
	@CRUD(order = 4)
	private Integer year;

	@Column(name = "\"duration\"", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@NotNull
	@Type(type = "interval")
	@CRUD(order = 5)
	private Integer duration;

	@OneToMany(mappedBy = "film")
	private Collection<Session> sessions;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return name + " (" + year + ")";
	}
}
