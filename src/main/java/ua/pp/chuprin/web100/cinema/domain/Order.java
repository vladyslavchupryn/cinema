package ua.pp.chuprin.web100.cinema.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "Orders")
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

	@Column(name = "customerName", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
	@Basic
	private String customerName;

	@Column(name = "price", nullable = false, insertable = true, updatable = true, length = 2147483647, precision = 0)
	@Basic
	private Double price;

	@Column(name = "comment", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
	@Basic
	private String comment;

	@ManyToOne
	@JoinColumn(name = "placeID", referencedColumnName = "id", nullable = false)
	private Place placeByPlaceId;

	@ManyToOne
	@JoinColumn(name = "seasonID", referencedColumnName = "id", nullable = false)
	private Session sessionBySeasonId;

	@ManyToMany
	@JoinTable(
		name = "OrdersCorrelations",
		joinColumns = {@JoinColumn(name = "orderID")},
		inverseJoinColumns = {@JoinColumn(name = "correlationID")}
	)
	private Collection<Correlation> ordersCorrelationsesById;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public Collection<Correlation> getOrdersCorrelationsesById() {
		return ordersCorrelationsesById;
	}

	public void setOrdersCorrelationsesById(Collection<Correlation> ordersCorrelationsesById) {
		this.ordersCorrelationsesById = ordersCorrelationsesById;
	}

	public Place getPlaceByPlaceId() {
		return placeByPlaceId;
	}

	public void setPlaceByPlaceId(Place placeByPlaceId) {
		this.placeByPlaceId = placeByPlaceId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Session getSessionBySeasonId() {
		return sessionBySeasonId;
	}

	public void setSessionBySeasonId(Session sessionBySeasonId) {
		this.sessionBySeasonId = sessionBySeasonId;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (comment != null ? comment.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;

		if (comment != null ? !comment.equals(order.comment) : order.comment != null)
			return false;
		if (customerName != null ? !customerName.equals(order.customerName) : order.customerName != null)
			return false;
		if (id != null ? !id.equals(order.id) : order.id != null)
			return false;
		if (price != null ? !price.equals(order.price) : order.price != null)
			return false;

		return true;
	}
}
