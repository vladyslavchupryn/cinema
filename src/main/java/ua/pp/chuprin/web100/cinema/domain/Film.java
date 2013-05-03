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

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ua.pp.chuprin.web100.cinema.tools.Interval;

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

	@Column(name = "\"name\"", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
	@Basic
	private String name;

	@Column(name = "\"author\"", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
	@Basic
	private String author;

	@Column(name = "\"genre\"", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
	@Basic
	private String genre;

	@Column(name = "\"country\"", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
	@Basic
	private String country;

	@Column(name = "\"year\"", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Basic
	private Integer year;

	@Column(name = "\"duration\"", nullable = false, insertable = true, updatable = true, length = 49, precision = 6)
	@Type(type = "interval")
	private Integer duration;

	@OneToMany(mappedBy = "film")
	private Collection<Session> sessionsesById;

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

	public Collection<Session> getSessionsesById() {
		return sessionsesById;
	}

	public void setSessionsesById(Collection<Session> sessionsesById) {
		this.sessionsesById = sessionsesById;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (author != null ? author.hashCode() : 0);
		result = 31 * result + (genre != null ? genre.hashCode() : 0);
		result = 31 * result + (country != null ? country.hashCode() : 0);
		result = 31 * result + (year != null ? year.hashCode() : 0);
		result = 31 * result + (duration != null ? duration.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Film film = (Film) o;

		if (author != null ? !author.equals(film.author) : film.author != null)
			return false;
		if (country != null ? !country.equals(film.country) : film.country != null)
			return false;
		if (duration != null ? !duration.equals(film.duration) : film.duration != null)
			return false;
		if (genre != null ? !genre.equals(film.genre) : film.genre != null)
			return false;
		if (id != null ? !id.equals(film.id) : film.id != null) return false;
		if (name != null ? !name.equals(film.name) : film.name != null)
			return false;
		if (year != null ? !year.equals(film.year) : film.year != null)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return name + " (" + year + ")";
	}
}
