package ua.pp.chuprin.web100.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`OrdersCorrelations`")
public class OrderCorrelation {

	@ManyToOne
	@JoinColumn(name = "`correlationID`", referencedColumnName = "id", nullable = false)
	private Correlation correlationsByCorrelationId;

	@ManyToOne
	@JoinColumn(name = "`orderID`", referencedColumnName = "id", nullable = false)
	private Order orderByOrderId;

	public Correlation getCorrelationsByCorrelationId() {
		return correlationsByCorrelationId;
	}

	public void setCorrelationsByCorrelationId(Correlation correlationsByCorrelationId) {
		this.correlationsByCorrelationId = correlationsByCorrelationId;
	}

	public Order getOrderByOrderId() {
		return orderByOrderId;
	}

	public void setOrderByOrderId(Order orderByOrderId) {
		this.orderByOrderId = orderByOrderId;
	}
}
