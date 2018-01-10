package Repository;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF {
	// Create a singleton PersistenceManager class.
	private static final PersistenceManagerFactory pmfInstance = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

		private PMF() {
		}

		public static PersistenceManagerFactory get() {
			return pmfInstance;
		}
}
