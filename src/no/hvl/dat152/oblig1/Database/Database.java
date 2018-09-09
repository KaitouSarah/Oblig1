package no.hvl.dat152.oblig1.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Database {
	private HashMap<String, List<HashMap<String, Object>>> tables = new HashMap<>();

	private static Database INSTANCE;

	public static Database getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Database();
		}
		return INSTANCE;
	}

	public void addRow(String tableName, HashMap<String, Object> object) {
		// Gets table from tables
		List<HashMap<String, Object>> table = tables.get(tableName);

		// If it doesn't exist, create it
		if (table == null) {
			table = new ArrayList<>();
			tables.put(tableName, table);
		}

		// Add the row to the table
		table.add(new HashMap<>(object));
	}

	public List<HashMap<String, Object>> getObjects(String tableName, Predicate<HashMap<String, Object>> predicate) {
		// Get table
		List<HashMap<String, Object>> table = tables.get(tableName);

		// If the table doesn't exist return null
		if (table == null) return null;

		// Find the object in the table by testing it against a predicate
		return table
			.stream()
			.filter(predicate)
			/*
			Because we don't want there to be an active link between data in database and returned data,
			we create a copy.
			This is to enforce the rules of a database we are simulating.
			 */
			.map(HashMap::new)
			.collect(Collectors.toList());
	}

	public List<HashMap<String, Object>> getObjects(String tableName) {
		return getObjects(tableName, x -> true);
	}

	public HashMap<String, Object> getObject(String tableName, Predicate<HashMap<String, Object>> predicate) {
		return getObjects(tableName, predicate)
			.stream()
			.findFirst()
			// If we don't find any matching the predicate, return null
			.orElse(null);
	}
}
