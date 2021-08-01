package MainEngine;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;

public class Indexer {
	private static final Logger logger = Logger.getLogger(Indexer.class.getName());

	int id = 0;

	private static Indexer indexer;

	private Indexer() {
	}

	public static Indexer getInstance() {
		if (indexer == null) {
			indexer = new Indexer();
		}
		return indexer;
	}

	public void initiateIndexer() throws IOException {
		int count = 0;
		logger.log(Level.INFO, "Initiating Indexing");
		System.out.println(
				"*****************************************************************************************************************");

		System.out.println("Documents in sorted format: ");
		System.out.println(
				"*****************************************************************************************************************");

		for (File file : Parser.getListOfWebpages()) {
			System.out.println("" + (++count) + " - " + file.getName());
		}
		logger.log(Level.INFO, "Finished Indexing");

	}

}
