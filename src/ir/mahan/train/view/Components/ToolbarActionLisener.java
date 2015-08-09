package ir.mahan.train.view.Components;

import java.sql.SQLException;

public interface ToolbarActionLisener {

	void saveEventOccured() throws SQLException;

	void rereshEventOccured();

}
