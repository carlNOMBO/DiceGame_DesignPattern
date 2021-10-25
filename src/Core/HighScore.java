package Core;

public interface HighScore {

	/**
	 * 
	 * @param bestScore
	 */
	void add(Entry bestScore);

	void save(Entry score);

	void load();

}