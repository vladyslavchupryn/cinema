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
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "`Sessions`")
public class Session {
	@Column(name = "`id`", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Id
	@GeneratedValue(
		generator = "session_sequence_generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
		name = "session_sequence_generator",
		sequenceName = "`Sessions_id_seq`",
		allocationSize = 1
	)
	private Integer id;

	@Column(name = "`filmID`", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Basic
	private Integer filmId;

	@Column(name = "`hallID`", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Basic
	private Integer hallId;

	@Column(name = "`start`", nullable = false, insertable = true, updatable = true, length = 29, precision = 6)
	@Basic
	private Timestamp start;

	@OneToMany(mappedBy = "sessionsBySeasonId")
	private Collection<Order> ordersesById;

	@ManyToOne
	@JoinColumn(name = "`filmID`", referencedColumnName = "id", nullable = false)
	private Film filmByFilmId;

	@ManyToOne
	@JoinColumn(name = "`hallID`", referencedColumnName = "id", nullable = false)
	private Hall hallByHallId;

	public Film getFilmByFilmId() {
		return filmByFilmId;
	}

	public void setFilmByFilmId(Film filmByFilmId) {
		this.filmByFilmId = filmByFilmId;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public Hall getHallByHallId() {
		return hallByHallId;
	}

	public void setHallByHallId(Hall hallByHallId) {
		this.hallByHallId = hallByHallId;
	}

	public Integer getHallId() {
		return hallId;
	}

	public void setHallId(Integer hallId) {
		this.hallId = hallId;
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
		result = 31 * result + (filmId != null ? filmId.hashCode() : 0);
		result = 31 * result + (hallId != null ? hallId.hashCode() : 0);
		result = 31 * result + (start != null ? start.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Session session = (Session) o;

		if (filmId != null ? !filmId.equals(session.filmId) : session.filmId != null)
			return false;
		if (hallId != null ? !hallId.equals(session.hallId) : session.hallId != null)
			return false;
		if (id != null ? !id.equals(session.id) : session.id != null)
			return false;
		if (start != null ? !start.equals(session.start) : session.start != null)
			return false;

		return true;
	}
}
