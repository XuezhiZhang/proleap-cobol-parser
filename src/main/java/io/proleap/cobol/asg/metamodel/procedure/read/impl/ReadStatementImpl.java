/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.read.impl;

import io.proleap.cobol.Cobol85Parser.ReadIntoContext;
import io.proleap.cobol.Cobol85Parser.ReadKeyContext;
import io.proleap.cobol.Cobol85Parser.ReadStatementContext;
import io.proleap.cobol.Cobol85Parser.ReadWithContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.Scope;
import io.proleap.cobol.asg.metamodel.call.Call;
import io.proleap.cobol.asg.metamodel.procedure.AtEnd;
import io.proleap.cobol.asg.metamodel.procedure.InvalidKey;
import io.proleap.cobol.asg.metamodel.procedure.NotAtEnd;
import io.proleap.cobol.asg.metamodel.procedure.NotInvalidKey;
import io.proleap.cobol.asg.metamodel.procedure.StatementType;
import io.proleap.cobol.asg.metamodel.procedure.StatementTypeEnum;
import io.proleap.cobol.asg.metamodel.procedure.impl.StatementImpl;
import io.proleap.cobol.asg.metamodel.procedure.read.Into;
import io.proleap.cobol.asg.metamodel.procedure.read.Key;
import io.proleap.cobol.asg.metamodel.procedure.read.ReadStatement;
import io.proleap.cobol.asg.metamodel.procedure.read.With;

public class ReadStatementImpl extends StatementImpl implements ReadStatement {

	protected AtEnd atEnd;

	protected final ReadStatementContext ctx;

	protected Call fileCall;

	protected Into into;

	protected InvalidKey invalidKey;

	protected Key key;

	protected boolean nextRecord;

	protected NotAtEnd notAtEnd;

	protected NotInvalidKey notInvalidKey;

	protected final StatementType statementType = StatementTypeEnum.READ;

	protected With with;

	public ReadStatementImpl(final ProgramUnit programUnit, final Scope scope, final ReadStatementContext ctx) {
		super(programUnit, scope, ctx);

		this.ctx = ctx;
	}

	@Override
	public Into addInto(final ReadIntoContext ctx) {
		Into result = (Into) getASGElement(ctx);

		if (result == null) {
			result = new IntoImpl(programUnit, ctx);

			final Call intoCall = createCall(ctx.identifier());
			result.setIntoCall(intoCall);

			into = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public Key addKey(final ReadKeyContext ctx) {
		Key result = (Key) getASGElement(ctx);

		if (result == null) {
			result = new KeyImpl(programUnit, ctx);

			final Call keyCall = createCall(ctx.qualifiedDataName());
			result.setKeyCall(keyCall);

			key = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public With addWith(final ReadWithContext ctx) {
		With result = (With) getASGElement(ctx);

		if (result == null) {
			result = new WithImpl(programUnit, ctx);

			// type
			final With.WithType type;

			if (ctx.KEPT() != null) {
				type = With.WithType.KEPT_LOCK;
			} else if (ctx.NO() != null) {
				type = With.WithType.NO_LOCK;
			} else if (ctx.WAIT() != null) {
				type = With.WithType.WAIT;
			} else {
				type = null;
			}

			result.setWithType(type);

			with = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public AtEnd getAtEnd() {
		return atEnd;
	}

	@Override
	public Call getFileCall() {
		return fileCall;
	}

	@Override
	public Into getInto() {
		return into;
	}

	@Override
	public InvalidKey getInvalidKey() {
		return invalidKey;
	}

	@Override
	public Key getKey() {
		return key;
	}

	@Override
	public NotAtEnd getNotAtEnd() {
		return notAtEnd;
	}

	@Override
	public NotInvalidKey getNotInvalidKey() {
		return notInvalidKey;
	}

	@Override
	public StatementType getStatementType() {
		return statementType;
	}

	@Override
	public With getWith() {
		return with;
	}

	@Override
	public boolean isNextRecord() {
		return nextRecord;
	}

	@Override
	public void setAtEnd(final AtEnd atEnd) {
		this.atEnd = atEnd;
	}

	@Override
	public void setFileCall(final Call fileCall) {
		this.fileCall = fileCall;
	}

	@Override
	public void setInvalidKey(final InvalidKey invalidKey) {
		this.invalidKey = invalidKey;
	}

	@Override
	public void setNextRecord(final boolean nextRecord) {
		this.nextRecord = nextRecord;
	}

	@Override
	public void setNotAtEnd(final NotAtEnd notAtEnd) {
		this.notAtEnd = notAtEnd;
	}

	@Override
	public void setNotInvalidKey(final NotInvalidKey notInvalidKey) {
		this.notInvalidKey = notInvalidKey;
	}

}
