package org.openlca.app.wizards;

import java.util.UUID;

import org.eclipse.swt.widgets.Composite;
import org.openlca.app.Messages;
import org.openlca.app.rcp.ImageType;
import org.openlca.core.model.ImpactMethod;

class ImpactMethodWizardPage extends AbstractWizardPage<ImpactMethod> {

	public ImpactMethodWizardPage() {
		super("LCIAMethodWizardPage");
		setTitle(Messages.NewImpactMethod);
		setMessage(Messages.CreatesANewImpactMethod);
		setImageDescriptor(ImageType.IMPACT_METHOD_WIZARD.getDescriptor());
		setPageComplete(false);
	}

	@Override
	protected void createContents(final Composite container) {
	}

	@Override
	public ImpactMethod createModel() {
		ImpactMethod method = new ImpactMethod();
		method.setRefId(UUID.randomUUID().toString());
		method.setName(getModelName());
		method.setDescription(getModelDescription());
		return method;
	}

}
