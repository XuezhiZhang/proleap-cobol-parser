/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.data.screen.impl;

import io.proleap.cobol.Cobol85Parser.ScreenDescriptionUsageClauseContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.data.screen.UsageClause;
import io.proleap.cobol.asg.metamodel.impl.CobolDivisionElementImpl;

public class UsageClauseImpl extends CobolDivisionElementImpl implements UsageClause {

	protected ScreenDescriptionUsageClauseContext ctx;

	protected UsageClauseType usageClauseType;

	public UsageClauseImpl(final ProgramUnit programUnit, final ScreenDescriptionUsageClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public UsageClauseType getUsageClauseType() {
		return usageClauseType;
	}

	@Override
	public void setUsageClauseType(final UsageClauseType usageClauseType) {
		this.usageClauseType = usageClauseType;
	}

}
