package ua.pp.chuprin.web100.cinema.domain.worker;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@javax.persistence.Entity
@Table(name = "\"Workers\"")
@Entity(
	mutable = false // в мониторинге нет возможности редактировать
)
public class Worker {

	@Id
	@Column(name = "\"id\"")
	@GeneratedValue(
		generator = "worker_sequence_generator",
		strategy = GenerationType.SEQUENCE
	)
	@SequenceGenerator(
		name = "worker_sequence_generator",
		sequenceName = "\"Workers_id_seq\"",
		allocationSize = 1
	)
	private Integer id;

	@Basic
	@Column(name = "\"IP\"")
	private String ip;

	public Integer getId() {
		return id;
	}

	public String getIp() {
		return ip;
	}
}
