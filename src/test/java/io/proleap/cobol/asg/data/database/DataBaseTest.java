package io.proleap.cobol.asg.data.database;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import io.proleap.cobol.CobolTestBase;
import io.proleap.cobol.asg.metamodel.CompilationUnit;
import io.proleap.cobol.asg.metamodel.Program;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.data.DataDivision;
import io.proleap.cobol.asg.metamodel.data.database.DataBaseSection;
import io.proleap.cobol.asg.metamodel.data.database.DataBaseSectionEntry;
import io.proleap.cobol.asg.runner.impl.CobolParserRunnerImpl;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

public class DataBaseTest extends CobolTestBase {

	@Test
	public void test() throws Exception {
		final File inputFile = new File("src/test/resources/io/proleap/cobol/asg/data/database/Database.cbl");
		final Program program = new CobolParserRunnerImpl().analyzeFile(inputFile, CobolSourceFormatEnum.TANDEM);

		final CompilationUnit compilationUnit = program.getCompilationUnit("Database");
		final ProgramUnit programUnit = compilationUnit.getProgramUnit();
		final DataDivision dataDivision = programUnit.getDataDivision();
		final DataBaseSection dataBaseSection = dataDivision.getDataBaseSection();

		assertEquals(2, dataBaseSection.getDataBaseSectionEntries().size());

		{
			final DataBaseSectionEntry dataBaseSectionEntry1 = dataBaseSection.getDataBaseSectionEntries().get(0);
			assertEquals(Long.valueOf(1), dataBaseSectionEntry1.getIntegerLiteral().getValue());
			assertEquals("SOMELITERAL", dataBaseSectionEntry1.getValueStmt1().getValue());
			assertEquals("SOMELITERAL2", dataBaseSectionEntry1.getValueStmt2().getValue());
		}

		{
			final DataBaseSectionEntry dataBaseSectionEntry2 = dataBaseSection.getDataBaseSectionEntries().get(1);
			assertEquals(Long.valueOf(2), dataBaseSectionEntry2.getIntegerLiteral().getValue());
			assertEquals("SOMELITERAL3", dataBaseSectionEntry2.getValueStmt1().getValue());
			assertEquals("SOMELITERAL4", dataBaseSectionEntry2.getValueStmt2().getValue());
		}
	}
}