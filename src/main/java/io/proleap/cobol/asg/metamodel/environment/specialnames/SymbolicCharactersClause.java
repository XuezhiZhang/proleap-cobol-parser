/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.environment.specialnames;

import io.proleap.cobol.asg.metamodel.CobolDivisionElement;

public interface SymbolicCharactersClause extends CobolDivisionElement {

	enum SymbolicCharactersClauseType {
		ALPHA_NUMERIC, NATIONAL
	}

	SymbolicCharactersClauseType getSymbolicCharactersClauseType();

	void setSymbolicCharactersClauseType(SymbolicCharactersClauseType symbolicCharactersClauseType);
}
