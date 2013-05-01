package ua.pp.chuprin.web100.cinema.domain.dataset.worker;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Entity;

@MappedSuperclass
/*
	не факт что в данном случае на что-то влияет так как наверняка не
	наследуется
 */
@Entity(mutable = false)
public class Type {

	@Id
	@Column(name = "\"id\"")
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "type_id_generator"
	)
	/*
		в данном сучае генератор должен быть тут, а не у класса
		так как аннотации не наследуются
	 */
	@SequenceGenerator(
		name = "type_id_generator",
		sequenceName = "\"Type_id_seq\""
	)
	@Basic
	private Short id;

	@Basic
	@Column(name = "\"name\"")
	private String name;

	@Basic
	@Column(name = "\"value\"")
	private String value;

	public Short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
