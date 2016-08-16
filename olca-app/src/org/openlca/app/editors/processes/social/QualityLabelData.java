package org.openlca.app.editors.processes.social;

import java.io.InputStream;
import java.util.Properties;

import org.eclipse.swt.graphics.Color;
import org.openlca.app.util.Colors;
import org.openlca.core.model.PedigreeMatrixRow;
import org.slf4j.LoggerFactory;

class QualityLabelData {

	private Properties properties;

	QualityLabelData() {
		properties = new Properties();
		try (InputStream is = getClass()
				.getResourceAsStream("quality_data.properties")) {
			properties.load(is);
		} catch (Exception e) {
			LoggerFactory.getLogger(getClass()).error(
					"Could not load properties quality_data", e);
		}
	}

	public String getRowLabel(PedigreeMatrixRow row) {
		return properties.getProperty(row.name());
	}

	public String getLabel(PedigreeMatrixRow row, int score) {
		return properties.getProperty(row.name() + "." + score);
	}

	public static Color[] getColors() {
		Color[] colors = new Color[5];
		colors[0] = Colors.get(210, 230, 185);
		colors[1] = Colors.get(233, 243, 199);
		colors[2] = Colors.get(251, 242, 209);
		colors[3] = Colors.get(246, 207, 191);
		colors[4] = Colors.get(246, 182, 174);
		return colors;
	}

}