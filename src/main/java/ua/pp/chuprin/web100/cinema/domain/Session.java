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
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "\"Sessions\"")
public class Session {
	@Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Id
	@GeneratedValue(
		generator = "session_sequence_generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
		name = "session_sequence_generator",
		sequenceName = "\"Sessions_id_seq\"",
		allocationSize = 1
	)
	private Integer id;

	@Column(name = "\"start\"", nullable = false, insertable = true, updatable = true, length = 29, precision = 6)
	@Basic
	private Timestamp start;

	public Float getPercent() {
		return percent;
	}

	public void setPercent(Float percent) {
		this.percent = percent;
	}

	@Column(
		name = "\"percent\"",
		nullable = false,
		insertable = true,
		updatable = true,
		length = 8,

		precision = 8
	)
	@Basic
	private Float percent;

	@OneToMany(mappedBy = "session")
	private Collection<Order> ordersesById;

	public void setFilm(Film film) {
		this.film = film;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	@ManyToOne(
		fetch = FetchType.LAZY
	)
	@JoinColumn(name = "\"filmID\"", referencedColumnName = "id", nullable = false)
	private Film film;

	@ManyToOne(
		fetch = FetchType.LAZY
	)
	@JoinColumn(name = "\"hallID\"", referencedColumnName = "id", nullable = false)
	private Hall hall;

	public Film getFilm() {
		return film;
	}

	public Hall getHall() {
		return hall;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<Order> getOrdersesById() {
		return ordersesById;
	}

	public void setOrdersesById(Collection<Order> ordersesById) {
		this.ordersesById = ordersesById;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Session session = (Session) o;

		if (id != null ? !id.equals(session.id) : session.id != null)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return film + " - " + hall + " : " + start;
	}
}
