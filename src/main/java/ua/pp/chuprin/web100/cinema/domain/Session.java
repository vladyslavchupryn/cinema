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
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Collection;

import ua.pp.chuprin.web100.cinema.tools.crud.annotations.CRUD;

@Entity
@Table(name = "\"Sessions\"")
@org.hibernate.annotations.Entity(
	dynamicInsert = true,
	dynamicUpdate = true
)
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
	@NotNull
	@CRUD(order = 100)
	private Timestamp start;

	@Column(
		name = "\"percent\"",
		insertable = true,
		updatable = true,
		length = 8,
		precision = 8
	)
	@Basic
	@CRUD(order = 200)
	private Float percent;

	@OneToMany(mappedBy = "session")
	private Collection<Order> orders;

	@ManyToOne(
		fetch = FetchType.LAZY
	)
	@JoinColumn(name = "\"filmID\"", referencedColumnName = "id", nullable = false)
	@CRUD(order = 300)
	private Film film;

	@ManyToOne(
		fetch = FetchType.LAZY
	)
	@JoinColumn(name = "\"hallID\"", referencedColumnName = "id", nullable = false)
	@CRUD(order = 400)
	private Hall hall;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> ordersesById) {
		this.orders = ordersesById;
	}

	public Float getPercent() {
		return percent;
	}

	public void setPercent(Float percent) {
		this.percent = percent;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return film + " - " + hall + " : " + start;
	}
}
