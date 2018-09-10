package no.hvl.dat152.oblig1.Database;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class DatabaseEAOModel {
	private final String tableName;
	private final Database database;

	public DatabaseEAOModel(String tableName) {
		this.tableName = tableName;
		this.database = Database.getInstance();
	}

	protected static DatabaseEAOModel INSTANCE;

	protected List<HashMap<String, Object>> getObjects() {
		return database.getObjects(tableName);
	}

	protected HashMap<String, Object> getObject (String key, Object value) {
		return getObject(object -> object.get(key) == value);
	}

	protected HashMap<String, Object> getObject (Predicate<HashMap<String, Object>> predicate) {
		return database.getObject(tableName, predicate);
	}

	protected void createObject (HashMap<String, Object> object) {
		database.addRow(tableName, object);
	}

	protected void replaceObject (HashMap<String, Object> object, Predicate<HashMap<String, Object>> predicate) {
		database.replaceRow(tableName, predicate, object);
	}
}
