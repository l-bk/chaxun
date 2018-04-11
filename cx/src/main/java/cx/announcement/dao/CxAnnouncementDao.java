package cx.announcement.dao;

import cx.announcement.entity.CxAnnouncement;

import java.util.List;

public interface CxAnnouncementDao {

    public List<CxAnnouncement> findList();
}
