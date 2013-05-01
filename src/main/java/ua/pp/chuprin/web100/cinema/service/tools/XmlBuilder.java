package ua.pp.chuprin.web100.cinema.service.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlBuilder {
	protected Document document;

	public XmlBuilder(Document document) {
		this.document = document;
	}

	protected void setText(Element element, Object value) {
		if (value == null) {
			writeNull(element);
		} else {
			setText(element, String.valueOf(value));
		}
	}

	protected void setText(Element element, Long value) {
		if (value == null) {
			writeNull(element);
		} else {
			setText(element, String.valueOf(value));
		}
	}

	protected void setText(Element element, Short value) {
		if (value == null) {
			writeNull(element);
		} else {
			setText(element, String.valueOf(value));
		}
	}

	protected void setText(Element element, Integer value) {
		if (value == null) {
			writeNull(element);
		} else {
			setText(element, String.valueOf(value));
		}
	}

	private void writeNull(Element element) {
		String nullString = null;
		setText(element, nullString);
	}

	protected void setText(Element element, String text) {
		if (text == null) {
			text = "null";
		}

		element.appendChild(document.createTextNode(text));
	}

	protected void setText(Element element, Float value) {
		if (value == null) {
			writeNull(element);
		} else {
			setText(element, String.valueOf(value));
		}
	}

	protected void setText(Element element, Boolean value) {
		if (value == null) {
			writeNull(element);
		} else {
			setText(element, String.valueOf(value));
		}
	}
}
