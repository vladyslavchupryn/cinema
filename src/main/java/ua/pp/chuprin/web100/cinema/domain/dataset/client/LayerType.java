package ua.pp.chuprin.web100.cinema.domain.dataset.client;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "`LayerType`")
@GenericGenerator(
	name = "my_sequence_generator",
	strategy = "sequence",
	parameters = {
		@Parameter(name = "`sequence`", value = "\"Type_id_seq\"")
	}
)
@org.hibernate.annotations.Entity(
	// пример использования динамической генерации запросов
	dynamicInsert = true,
	dynamicUpdate = true,

	mutable = false // сейчас типы неизменны и добавляются через pgAdmin
)
public class LayerType {

	@Id
	@Column(name = "`id`")
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "my_sequence_generator"
	)
	@Basic
	private Short id;

	@Column(
		name = "`name`",
		/**
		 пример описания unique черз свойство аннотации. возможен вариант
		 при помощи анотации к классу {@link DataProviderType}
		 */
		unique = true,
		nullable = false
	)
	@Basic
	private String name;

// TODO 100% CPU
//	@CollectionOfElements(
//		targetElement = String.class
//	)
//	@JoinTable(
//		name = "`ClientDatasets`",
//		joinColumns = {
//			@JoinColumn(
//				name = "`layer_type`",
//				// в данном случае может быть опущенно так как это поле
//				// можно определить по @Id (если бы был первичный ключ из
//				// нескольких полей то нельзя было бы)
//				referencedColumnName = "id"
//			)
//		}
//	)
//	@Column(name = "`Name`")
//	private Set<String> datasetNames = new HashSet<String>();

	@Column(
		name = "`value`",
		unique = true,
		nullable = false
	)
	@Basic
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
