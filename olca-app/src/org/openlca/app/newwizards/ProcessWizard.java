package org.openlca.app.newwizards;

import org.openlca.core.application.Messages;
import org.openlca.core.application.db.Database;
import org.openlca.core.database.BaseDao;
import org.openlca.core.model.Process;

public class ProcessWizard extends
		AbstractWizard<org.openlca.core.model.Process> {

	@Override
	protected String getTitle() {
		return Messages.Processes_WizardTitle;
	}

	@Override
	protected BaseDao<Process> createDao() {
		return Database.createDao(Process.class);
	}

	@Override
	protected AbstractWizardPage<Process> createPage() {
		return new ProcessWizardPage();
	}

}