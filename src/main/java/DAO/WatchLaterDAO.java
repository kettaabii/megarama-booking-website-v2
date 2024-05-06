package DAO;

import Modals.Reservation;
import Modals.Watchlater;

import java.sql.SQLException;
import java.util.List;

public interface WatchLaterDAO {
    void AddToWatchLater(Watchlater watchlater) throws SQLException;

    List<Watchlater> getWishlist(String viewer);

    void RemoveFromWatchLater(Watchlater watchlater) throws SQLException;

}
