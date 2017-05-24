/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.environment.inputoutput.filecontrol.impl;

import io.proleap.cobol.Cobol85Parser.OrganizationClauseContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.environment.inputoutput.filecontrol.OrganizationClause;
import io.proleap.cobol.asg.metamodel.impl.CobolDivisionElementImpl;

public class OrganizationClauseImpl extends CobolDivisionElementImpl implements OrganizationClause {

	protected final OrganizationClauseContext ctx;

	protected Mode mode;

	protected OrganizationClauseType organizationClauseType;

	public OrganizationClauseImpl(final ProgramUnit programUnit, final OrganizationClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public Mode getMode() {
		return mode;
	}

	@Override
	public OrganizationClauseType getOrganizationClauseType() {
		return organizationClauseType;
	}

	@Override
	public void setMode(final Mode mode) {
		this.mode = mode;
	}

	@Override
	public void setOrganizationClauseType(final OrganizationClauseType organizationClauseType) {
		this.organizationClauseType = organizationClauseType;
	}

}
