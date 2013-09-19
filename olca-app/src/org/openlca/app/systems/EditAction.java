package org.openlca.app.systems;

import org.eclipse.jface.action.Action;
import org.openlca.app.Messages;
import org.openlca.app.editors.graphical.GraphicalEditorInput;
import org.openlca.app.editors.graphical.ProductSystemGraphEditor;
import org.openlca.app.resources.ImageType;
import org.openlca.app.util.Editors;
import org.openlca.core.model.descriptors.ProductSystemDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditAction extends Action {

	private Logger log = LoggerFactory.getLogger(getClass());

	public EditAction() {
		setImageDescriptor(ImageType.PRODUCT_SYSTEM_ICON.getDescriptor());
		setText(Messages.OpenEditorAction_Text);
	}

	@Override
	public void run() {
		GraphicalEditorInput input = getInput();
		if (input == null) {
			log.error("unexpected error: model editor input is null");
			return;
		}
		Editors.open(input, ProductSystemGraphEditor.ID);
	}

	private GraphicalEditorInput getInput() {
		ProductSystemEditor editor = Editors.getActive();
		if (editor == null)
			return null;
		return new GraphicalEditorInput((ProductSystemDescriptor) editor
				.getEditorInput().getDescriptor());
	}
}
