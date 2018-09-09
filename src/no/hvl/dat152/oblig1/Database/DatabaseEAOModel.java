package no.hvl.dat152.oblig1.Database;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;

public class DatabaseEAOModel {
	private final String tableName;
	private final Database database;

	public DatabaseEAOModel(String tableName) {
		this.tableName = tableName;
		this.database = Database.getInstance();
	}

	private static DatabaseEAOModel INSTANCE;

	public static DatabaseEAOModel getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DatabaseEAOModel(null);
		}
		return INSTANCE;
	}

	protected List<HashMap<String, Object>> getObjects() {
		return database.getObjects(tableName);
	}

	protected HashMap<String, Object> getObject (String key, Object value) {
		return database.getObject(tableName, object -> object.get(key) == value);
	}

	protected void createObject (HashMap<String, Object> object) {
		database.addRow(tableName, object);
	}
}
