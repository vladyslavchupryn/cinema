package ua.pp.chuprin.web100.cinema.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;

import org.hibernate.validator.constraints.Length;
import ua.pp.chuprin.web100.cinema.tools.crud.annotations.CRUD;

@Entity
@Table(name = "\"Orders\"")
@org.hibernate.annotations.Entity(
	dynamicInsert = true,
	dynamicUpdate = true
)
public class Order {

	@Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
	@Id
	@GeneratedValue(
		generator = "order_sequence_generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
		name = "order_sequence_generator",
		sequenceName = "\"Orders_id_seq\"",
		allocationSize = 1
	)
	private Integer id;

	@Column(name = "\"customerName\"", nullable = false, insertable = true, updatable = true, length = 126, precision = 0)
	@Basic
	@NotNull
	@Length(min = 3, max = 126)
	@CRUD(order = 100)
	private String customerName;

	@Column(name = "\"price\"", nullable = false, insertable = true, updatable = true, length = 126, precision = 0)
	@Basic
	@NotNull
	@CRUD(order = 200)
	private Double price;

	@Column(name = "\"comment\"", insertable = true, updatable = true, length = 126, precision = 0)
	@Basic
	@CRUD(order = 700)
	private String comment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"placeID\"", referencedColumnName = "id", nullable = false)
	@NotNull
	@CRUD(order = 400)
	private Place place;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"seasonID\"", referencedColumnName = "id", nullable = false)
	@NotNull
	@CRUD(order = 500)
	private Session session;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"statusID\"", referencedColumnName = "id", nullable = false)
	@NotNull
	@CRUD(order = 150)
	private OrderStatus status;

	@ManyToMany
	@JoinTable(
		name = "\"OrdersCorrelations\"",
		joinColumns = {@JoinColumn(name = "\"orderID\"")},
		inverseJoinColumns = {@JoinColumn(name = "\"correlationID\"")}
	)
	@CRUD(order = 600, joinType = Correlation.class)
	private Collection<Correlation> correlations;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Collection<Correlation> getCorrelations() {
		return correlations;
	}

	public void setCorrelations(Collection<Correlation> correlations) {
		this.correlations = correlations;
	}

	public Collection<Integer> getCorrelationsId() {
		Collection<Integer> result = new HashSet<Integer>();
		if (this.correlations != null) {
			for (Correlation cur : this.correlations) {
				result.add(cur.getId());
			}
		}

		return result;
	}

	public void setCorrelationsId(Collection<Integer> correlations) {
		this.correlations = new HashSet<Correlation>();
		for (Integer currentId : correlations) {
			Correlation currentCorrelation = new Correlation();
			currentCorrelation.setId(currentId);
			this.correlations.add(currentCorrelation);
		}
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place placeByPlaceId) {
		this.place = placeByPlaceId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session sessionBySeasonId) {
		this.session = sessionBySeasonId;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return session + " - " + place + " - " + customerName;
	}
}
