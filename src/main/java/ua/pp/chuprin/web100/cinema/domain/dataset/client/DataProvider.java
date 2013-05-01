package ua.pp.chuprin.web100.cinema.domain.dataset.client;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DataProvider {
	@Column(name = "`dataProvider_dataset_id`")
	@Basic
	private String datasetId;

	@Column(name = "`dataProvider_type`")
	@Basic
	private Short type;

	/**
	 * Пример простейшего маппинга. Мапинг в связанной таблице не обязателен
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "`dataProvider_type`",
		insertable = false,
		updatable = false
	)
	private DataProviderType typeValue;

	public DataProviderType getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(DataProviderType typeValue) {
		this.typeValue = typeValue;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
}
