package cx.announcement.service.Impl;

import cx.announcement.dao.CxAnnouncementDao;
import cx.announcement.entity.CxAnnouncement;
import cx.announcement.service.CxAnnouncementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/CxAnnouncementService")
public class CxAnnouncementServiceImpl implements CxAnnouncementService {

    @Resource
    private CxAnnouncementDao cxAnnouncementDao;

    public List<CxAnnouncement> findList() {
        return cxAnnouncementDao.findList();
    }
}
